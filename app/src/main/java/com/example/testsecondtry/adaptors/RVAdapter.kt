package com.example.testsecondtry.adaptors

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testsecondtry.BrowserFragment
import com.example.testsecondtry.databinding.ItemRowBinding
import com.example.testsecondtry.retrofit.Photos


class RVAdapter(
    private val entries: ArrayList<Photos.Result>,
    private val activity: BrowserFragment

) : RecyclerView.Adapter<RVAdapter.ItemViewHolder>() {
    class ItemViewHolder(val binding: ItemRowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val entry = entries[position]!!
        holder.binding.apply {
           Glide.with(activity).load(entry.links.download).into(ivThumbnail)
           llItemRow.setOnClickListener {

               activity.openImg(entry.links.download)
               activity.addPhoto(entry.alt_description, entry.links.download)
               Toast.makeText(activity.activity,"photo added to db", Toast.LENGTH_LONG).show()
           }

        }
    }

    override fun getItemCount() = entries.size

}