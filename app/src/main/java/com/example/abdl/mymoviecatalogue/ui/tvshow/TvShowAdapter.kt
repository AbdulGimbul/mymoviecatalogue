package com.example.abdl.mymoviecatalogue.ui.tvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.abdl.mymoviecatalogue.data.source.local.entity.TvShowEntity
import com.example.abdl.mymoviecatalogue.databinding.ItemsTvshowBinding
import com.example.abdl.mymoviecatalogue.ui.detail.DetailTvShowActivity

class TvShowAdapter : PagedListAdapter<TvShowEntity, TvShowAdapter.TvShowViewHolder>(DIFF_CALLBACK) {
    companion object{
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvShowEntity>(){
            override fun areItemsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem.tvShowId == newItem.tvShowId
            }

            override fun areContentsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val itemsTvShowBinding = ItemsTvshowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(itemsTvShowBinding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val tvshow = getItem(position)
        if (tvshow != null) {
            holder.bind(tvshow)
        }
    }

    fun getSwipedData(swipedPosition: Int): TvShowEntity? = getItem(swipedPosition)

    class TvShowViewHolder(private val binding: ItemsTvshowBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind (tvshow: TvShowEntity){
            with(binding){
                tvItemTitleTvshow.text = tvshow.title
                tvItemCreator.text = tvshow.creator
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailTvShowActivity::class.java)
                    intent.putExtra(DetailTvShowActivity.EXTRA_TVSHOW, tvshow.tvShowId)
                    itemView.context.startActivity(intent)
                }

                Glide.with(itemView.context)
                    .load(tvshow.image)
                    .into(imgTvshow)
            }
        }
    }
}