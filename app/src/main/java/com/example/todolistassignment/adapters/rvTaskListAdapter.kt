package com.example.todolistassignment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todolistassignment.databinding.RvTasksItemListBinding

class rvTaskListAdapter(
    val TempTaskList: List<String>,
    val listener: SelectedTask

) :
    RecyclerView.Adapter<rvTaskListAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            RvTasksItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val viewholder = ViewHolder(view)

        view.root.setOnClickListener {
            listener.ClickedTask(TempTaskList[viewholder.adapterPosition])
        }

        return viewholder
    }

    override fun getItemCount(): Int {
        return TempTaskList.size
    }

    class ViewHolder(binding: RvTasksItemListBinding) : RecyclerView.ViewHolder(binding.root) {
        val taskHeading = binding.tvTaskheading
        val taskDetails = binding.tvTaskDetails
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.taskHeading.text = TempTaskList[position]
    }
}

interface SelectedTask {
    fun ClickedTask(member: String)

}