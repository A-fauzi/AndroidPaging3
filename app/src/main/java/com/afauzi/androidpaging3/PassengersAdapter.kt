package com.afauzi.androidpaging3

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.afauzi.androidpaging3.data_model.Passenger
import com.afauzi.androidpaging3.databinding.ItemPassengerBinding
import com.bumptech.glide.Glide

class PassengersAdapter(private val context: Context): PagingDataAdapter<Passenger, PassengersAdapter.PassengersViewHolder>(PassengersComparator) {
    inner class PassengersViewHolder(private val binding: ItemPassengerBinding): RecyclerView.ViewHolder(binding.root) {
        fun bindPassenger(item: Passenger) = with(binding) {
            Glide.with(context).load(item.airline[0].logo).into(imageViewAirlinesLogo)
            textViewHeadquarters.text = item.airline[0].head_quaters
            textViewNameWithTrips.text = "${item.name}, ${item.trips} Trips"
        }
    }

    object PassengersComparator : DiffUtil.ItemCallback<Passenger>() {
        override fun areItemsTheSame(oldItem: Passenger, newItem: Passenger): Boolean {
            return oldItem._id == newItem._id
        }

        override fun areContentsTheSame(oldItem: Passenger, newItem: Passenger): Boolean {
            return oldItem == newItem
        }

    }

    override fun onBindViewHolder(holder: PassengersViewHolder, position: Int) {
        val item = getItem(position)
        item?.let { holder.bindPassenger(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PassengersViewHolder {
        return PassengersViewHolder(
            ItemPassengerBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }
}