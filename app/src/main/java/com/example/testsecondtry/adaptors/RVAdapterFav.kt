package com.example.testsecondtry.adaptors

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testsecondtry.FavoriteFragment
import com.example.testsecondtry.database.PhotoEntity
import com.example.testsecondtry.databinding.FavRowBinding

class RVAdapterFav(private val activity: FavoriteFragment) : RecyclerView.Adapter<RVAdapterFav.ItemViewHolder>() {
    private var photos = emptyList<PhotoEntity>()
    class ItemViewHolder(val binding: FavRowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemViewHolder {
        return ItemViewHolder(
            FavRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val photo = photos[position]

        holder.binding.apply {
          tvColor.text= photo.photoTitle
            Glide.with(activity).load(photo.PhotoLink).into(imageView)

         btDelete.setOnClickListener {
                activity.viewModel.deletePhoto(photo.id)
               Toast.makeText(activity.activity,"photo deleted",Toast.LENGTH_LONG).show()
            }

        }
    }

    override fun getItemCount() = photos.size

    fun update(shows: List<PhotoEntity>){
        println("UPDATING DATA")
        this.photos = shows
        notifyDataSetChanged()
    }
}