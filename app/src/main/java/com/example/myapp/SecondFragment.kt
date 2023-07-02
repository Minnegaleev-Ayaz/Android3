package com.example.myapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.myapp.databinding.FragmentSecondBinding

class SecondFragment : Fragment(R.layout.fragment_second) {
    private var binding: FragmentSecondBinding?=null
    private val options: RequestOptions = RequestOptions
        .diskCacheStrategyOf(DiskCacheStrategy.ALL)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSecondBinding.bind(view)
        val painting = getInfo()
        setInfo(painting)
        setImage(painting)
        binding?.btnBack?.setOnClickListener {
            findNavController().navigate(R.id.action_secondFragment_to_mainFragment)
        }

    }
    private fun getInfo():Painting{
        val id = arguments?.getInt("ID")
        return PaintingRepository.list.single{it.id==id}
    }
    private fun setInfo(painting: Painting) {
        binding?.tvId?.text = "ID: ${painting.id}"
        binding?.tvPaintings?.text = "Name: ${painting.name}"
        binding?.tvArtist?.text = "Artist: ${painting.artist}"
        binding?.tvDesc?.text = "Desc: ${painting.desc}"
    }

    private fun setImage(painting: Painting) {
        binding?.ivPaint?.let {
            Glide.with(this)
                .load(painting.url)
                .into(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}