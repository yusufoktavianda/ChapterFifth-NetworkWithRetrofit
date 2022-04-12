package binar.academy.networkingsample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import binar.academy.networkingsample.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
    private val arguments : DetailFragmentArgs by navArgs()
    private var _binding : FragmentDetailBinding?=null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            tvnameDetail.text = arguments.cars.name
            tvpriceDetail.text = arguments.cars.price.toString()
        }

    }
}