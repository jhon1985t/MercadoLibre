package com.jhonjto.mercadolibre.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.jhonjto.mercadolibre.adapters.RemoteJobAdapter
import com.jhonjto.mercadolibre.databinding.FragmentSearchBinding
import com.jhonjto.mercadolibre.databinding.ViewProgressBarBinding
import com.jhonjto.mercadolibre.utils.Constants
import com.jhonjto.mercadolibre.viewModels.SearchUiModel
import com.jhonjto.mercadolibre.viewModels.SearchViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.scope.viewModel


class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private lateinit var loadingBinding: ViewProgressBarBinding
    private val binding get() = _binding!!
    private lateinit var jobAdapter: RemoteJobAdapter

    private val viewModel: SearchViewModel by lifecycleScope.viewModel(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSearchBinding.inflate(
            inflater,
            container,
            false
        )

        loadingBinding = ViewProgressBarBinding.bind(binding.root)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (Constants.isNetworkAvailable(requireContext())) {
            searchJob()
        } else {
            Toast.makeText(activity,"No hay conexion a Internet", Toast.LENGTH_SHORT).show()
        }
    }

    private fun searchJob() {
        var job: Job? = null
        binding.etSearch.addTextChangedListener { editable ->
            job?.cancel()
            job = MainScope().launch {
                delay(500L)
                editable?.let {
                    if (editable.toString().isNotEmpty()) {
                        viewModel.searchProducts(editable.toString())
                    }
                }
            }
        }
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        jobAdapter = RemoteJobAdapter()
        binding.rvSearchJobs.apply {
            layoutManager = LinearLayoutManager(activity)
            setHasFixedSize(true)
            adapter = jobAdapter
        }

        viewModel.model.observe(viewLifecycleOwner, { response ->
            loadingBinding.progress.visibility =
                if (response == SearchUiModel.Loading) View.VISIBLE else View.GONE

            when (response) {
                is SearchUiModel.Content -> jobAdapter.differ.submitList(response.products)
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}
