package com.example.todolistassignment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todolistassignment.databinding.RvUserItemListBinding

class rvUserListAdapter(
    val UserList: List<String>,
    val listener: SelectedUser
) :
    RecyclerView.Adapter<rvUserListAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = RvUserItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val viewholder = ViewHolder(view)

        view.root.setOnClickListener {
            listener.ClickedMember(UserList[viewholder.adapterPosition])
        }


        return viewholder
    }

    override fun getItemCount(): Int {
        return UserList.size
    }

    class ViewHolder(binding: RvUserItemListBinding) : RecyclerView.ViewHolder(binding.root) {
        val name = binding.tvName
        val details = binding.tvDetails
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = UserList[position]
    }
}

interface SelectedUser {
    fun ClickedMember(member: String)
}
