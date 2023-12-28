package com.example.suitmedia_mobile_intern.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.suitmedia_mobile_intern.core.data.database.entity.UserEntity
import com.example.suitmedia_mobile_intern.databinding.UserRvBinding
import com.example.suitmedia_mobile_intern.ui.second.SecondScreenActivity
import com.example.suitmedia_mobile_intern.utils.Constants.USERNAME

class UserListAdapter
    : PagingDataAdapter<UserEntity, UserListAdapter.MyViewHolder>(DIFF_CALLBACK) {

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = getItem(position)
        if (data != null) {
            holder.bind(data)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =
            UserRvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    class MyViewHolder(private val binding: UserRvBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: UserEntity) {
            binding.apply {
                Glide.with(itemView.context)
                    .load(data.avatar)
                    .into(binding.rvAvatarIV)
                val fullName = data.firstName + " " + data.lastName
                rvNameTV.text = fullName
                rvEmailTV.text = data.email?.uppercase()
            }
            itemView.setOnClickListener {
                val toSecondScreen = Intent(itemView.context, SecondScreenActivity::class.java)
                toSecondScreen.putExtra(USERNAME, data.firstName + " " + data.lastName)
                itemView.context.startActivity(toSecondScreen)
            }
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<UserEntity>() {
            override fun areItemsTheSame(
                oldItem: UserEntity,
                newItem: UserEntity
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: UserEntity,
                newItem: UserEntity
            ): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}