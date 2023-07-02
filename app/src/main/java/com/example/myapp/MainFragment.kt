package com.example.myapp

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.myapp.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {
    private var binding: FragmentMainBinding?=null
    private var adapter: PaintingAdapter?=null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding=FragmentMainBinding.bind(view)
        Log.e("MainFragment","123")
        initAdapter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
    private fun initAdapter(){
        adapter = PaintingAdapter(PaintingRepository.list,
            Glide.with(this),
            {Painting->
            findNavController().navigate(R.id.action_mainFragment_to_secondFragment,
                createBundle(Painting.id)
            )
            })
        binding?.rvPainting?.adapter=adapter
    }
    companion object{
        fun createBundle(id:Int):Bundle{
            val bundle = Bundle()
            bundle.putInt("ID",id)
            return bundle
        }
    }

}