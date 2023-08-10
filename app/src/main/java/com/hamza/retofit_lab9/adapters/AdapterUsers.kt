package com.hamza.retofit_lab9.adapters;

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hamza.retofit_lab9.databinding.UserItemBinding
import com.hamza.retofit_lab9.models.UserModel


class AdapterUsers : RecyclerView.Adapter<AdapterUsers.Holder>() {

    var list: ArrayList<UserModel.Data>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = UserItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return Holder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: Holder, position: Int) {
        val data= list?.get(position)!!
        holder.binding.apply {
            txtName.text = "Name : ${data.first_name + "" + data.last_name}"
            txtEmail.text = "E-mail : ${data.email}"
        }
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }

    inner class Holder constructor(val binding: UserItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }


}