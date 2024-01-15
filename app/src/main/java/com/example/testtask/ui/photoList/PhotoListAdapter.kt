package com.example.testtask.ui.photoList

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.testtask.R
import com.example.testtask.core.extensions.openLink
import com.example.testtask.databinding.LayoutPhotoItemBinding
import com.example.testtask.domain.models.PhotoItem

class PhotoListAdapter: RecyclerView.Adapter<PhotoListAdapter.PhotoItemViewHolder>() {

    private var photoItems = listOf<PhotoItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoItemViewHolder {
        return PhotoItemViewHolder(
            binding = LayoutPhotoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false),
        )
    }

    override fun onBindViewHolder(holder: PhotoItemViewHolder, position: Int) {
        holder.bind(photoItems[position])
    }

    override fun getItemCount(): Int {
        return photoItems.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(photoItems: List<PhotoItem>) {
        this.photoItems = photoItems
        notifyDataSetChanged()
    }

    inner class PhotoItemViewHolder(
        private val binding: LayoutPhotoItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        /**
         * Here we parse html string to usual spanned object via default android method fromHtml(),
         * there are some difference in compare with web
         * if we want to display text exactly the same as it is displayed on the web
         * then we should parse html content manually
         * */
        fun bind(photoItem: PhotoItem) {

            binding.apply {
                ivPhoto.load(photoItem.imageLink) {
                    placeholder(R.drawable.no_image)
                    listener(
                        onError = { _, _ -> ivPhoto.setImageResource(R.drawable.no_image) }
                    )
                }

                tvPhotoDesc.text = HtmlCompat.fromHtml(photoItem.description, HtmlCompat.FROM_HTML_MODE_COMPACT)

                root.setOnClickListener {
                    photoItem.browserLink.openLink(it.context)
                }
            }
        }
    }
}