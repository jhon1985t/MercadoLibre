package com.jhonjto.mercadolibre.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.jhonjto.mercadolibre.R
import com.jhonjto.mercadolibre.databinding.FragmentDetailsBinding
import com.jhonjto.mercadolibre.databinding.ViewProgressBarBinding
import com.jhonjto.mercadolibre.viewModels.SearchUiModel
import com.jhonjto.mercadolibre.viewModels.SearchViewModel
import org.koin.android.ext.android.bind
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.scope.viewModel

class DetailsFragment : Fragment(R.layout.fragment_details) {

    private var _binding: FragmentDetailsBinding? = null
    private lateinit var loadingBinding: ViewProgressBarBinding
    private val binding get() = _binding!!
    private val args: DetailsFragmentArgs by navArgs()
    private val viewModel: SearchViewModel by lifecycleScope.viewModel(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDetailsBinding.inflate(
            inflater,
            container,
            false
        )

        loadingBinding = ViewProgressBarBinding.bind(binding.root)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        args.let {
            viewModel.detailsProduct(it.id)
            viewModel.model.observe(viewLifecycleOwner, { response ->
                loadingBinding.progress.visibility =
                    if (response == SearchUiModel.Loading) View.VISIBLE else View.GONE

                when (response) {
                    is SearchUiModel.Detail -> {
                        response.details.forEach { details ->
                            binding.tvId.text = details.body?.id
                            binding.tvCondition.text = details.body?.condition
                            binding.tvWarranty.text = details.body?.warranty
                            binding.tvPrice.text = details.body?.price.toString()
                            Glide.with(this)
                                .load(details.body?.thumbnail)
                                .diskCacheStrategy(DiskCacheStrategy.ALL)
                                .into(binding.ivProduct)
                            binding.tvName.text = details.body?.title
                        }
                    }
                }
            })
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}
