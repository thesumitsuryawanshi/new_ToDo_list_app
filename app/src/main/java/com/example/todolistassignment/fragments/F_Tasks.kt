package com.example.todolistassignment.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolistassignment.adapters.SelectedTask
import com.example.todolistassignment.adapters.rvTaskListAdapter
import com.example.todolistassignment.databinding.FragmentFTasksBinding
import com.google.android.material.snackbar.Snackbar

class F_Tasks : Fragment(), SelectedTask {
    lateinit var binding: FragmentFTasksBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFTasksBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvUserListSetUp()
    }

    private fun rvUserListSetUp() {

        val TempTaskList = listOf(
            "Task 0 ",
            "Task 1",
            "Task 3",
            "Task 4",
            "Task 2",
            "Task 5",
            "Task 6",
            "Task 7",
            "Task 8"
        )
        val adapter = rvTaskListAdapter(TempTaskList, this)
        binding.rvTaskList.adapter = adapter
        binding.rvTaskList.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

    }

    override fun ClickedTask(member: String) {


        AlertDialog.Builder(requireContext())
            .setTitle("Statistics")
            .setMessage("\n\n $member \n\n ")
            .setPositiveButton("Show detailed Statistics") { _, _ ->
                Snackbar.make(view?.rootView!!, "action pending", Snackbar.LENGTH_SHORT).show()
            }
            .setNegativeButton("Close") { _, _ -> }
            .show()

    }


}