package binar.academy.networkingsample

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import binar.academy.networkingsample.databinding.FragmentRegisterBinding
import binar.academy.networkingsample.model.RegisterResponseItem
import binar.academy.networkingsample.network.ApiClient
import binar.academy.networkingsample.request.RegisterRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterFragment : Fragment() {
    private var _binding : FragmentRegisterBinding?=null
    private val binding  get()= _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding =FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        registerRequest()
    }

    private fun registerRequest() {
        binding.apply {

            registerButton.setOnClickListener {
                val registerRequest = RegisterRequest(
                    email = emailEdittext.text.toString(),
                    password = passwordEdittext.text.toString(),
                    role = "admin"
                )
                ApiClient.retrofitService.registerAdmin(registerRequest).enqueue(object :
                    Callback<RegisterResponseItem> {
                    override fun onResponse(
                        call: Call<RegisterResponseItem>,
                        response: Response<RegisterResponseItem>
                    ) {
                        Log.d("recyclerfragment", "ini Data = ${response.body()}")
                    }

                    override fun onFailure(call: Call<RegisterResponseItem>, t: Throwable) {
                        Log.d("recyclerfragment", "Gagal")
                    }

                })
            }
        }
    }
}