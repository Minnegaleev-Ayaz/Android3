package com.example.myapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.myapp.databinding.ItemPaintingBinding


class PaintingAdapter(
    private var list: List<Painting>,
    private val glide: RequestManager,
    private val onItemClick: (Painting)->Unit,
) : RecyclerView.Adapter<PaintingItem>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int
    ): PaintingItem =
        PaintingItem(
            binding = ItemPaintingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            glide = glide,
            onItemClick = onItemClick,
        )

    override fun onBindViewHolder(holder: PaintingItem, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}