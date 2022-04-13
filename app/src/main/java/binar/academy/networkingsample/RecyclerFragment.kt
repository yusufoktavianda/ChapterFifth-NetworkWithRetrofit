package binar.academy.networkingsample

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import binar.academy.networkingsample.adapter.MainAdapter
import binar.academy.networkingsample.databinding.FragmentRecyclerBinding
import binar.academy.networkingsample.model.GetAllCarResponseItem
import binar.academy.networkingsample.model.RegisterResponseItem
import binar.academy.networkingsample.network.ApiClient
import binar.academy.networkingsample.request.RegisterRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecyclerFragment : Fragment() {
    private var _binding: FragmentRecyclerBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecyclerBinding.inflate(inflater, container, false)
        val view = binding.root
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fetchAllData()
        binding.apply {
            addFloatingbutton.setOnClickListener {
                it.findNavController().navigate(RecyclerFragmentDirections.actionRecyclerFragmentToRegisterFragment())
            }
        }
    }


    private fun fetchAllData(){
        ApiClient.retrofitService.allCar()
            .enqueue(object : Callback<List<GetAllCarResponseItem>>{
                override fun onResponse(
                    call: Call<List<GetAllCarResponseItem>>,
                    response: Response<List<GetAllCarResponseItem>>
                ) {
                    val body = response.body()
                    val code = response.code()
                    if (code == 200){
                        showList(body)
                        binding.loadingProgressBar.visibility=View.GONE
                    }else{
                        binding.loadingProgressBar.visibility=View.GONE
                    }
                }

                override fun onFailure(call: Call<List<GetAllCarResponseItem>>, t: Throwable) {
                    binding.loadingProgressBar.visibility=View.GONE
                }

            } )

    }

    private fun showList(data : List<GetAllCarResponseItem>?){
        val adapter = MainAdapter(object : MainAdapter.onClickListener{
            override fun onClickItem(data: GetAllCarResponseItem) {

            }
        })
        adapter.submitData(data)
        binding.recyclerView.adapter = adapter
    }

}