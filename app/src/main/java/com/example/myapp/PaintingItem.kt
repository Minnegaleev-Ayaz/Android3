package com.example.myapp

import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.RequestManager
import com.example.myapp.databinding.ItemPaintingBinding


class PaintingItem(
    private val binding: ItemPaintingBinding,
    private val glide: RequestManager,
    private val onItemClick: (Painting) -> Unit,
) :ViewHolder(binding.root){
    fun onBind(painting: Painting) {
        binding.run {
            tvPaintings.text=painting.name
            tvArtist.text = painting.artist
            glide
                .load(painting.url)
                .error(R.drawable.ic_action_name)
                .into(ivImage)
            root.setOnClickListener{
                onItemClick(painting)

            }
        }
    }
}