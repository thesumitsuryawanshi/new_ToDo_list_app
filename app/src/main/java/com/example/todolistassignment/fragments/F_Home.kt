package com.example.todolistassignment.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolistassignment.R
import com.example.todolistassignment.adapters.SelectedUser
import com.example.todolistassignment.adapters.rvUserListAdapter
import com.example.todolistassignment.databinding.FragmentFHomeBinding

class F_Home : Fragment(), SelectedUser {

    lateinit var binding: FragmentFHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btmNavBarSetUp()
        rvUserListSetUp()

        binding.fabBtn.setOnClickListener {
            val view =
                LayoutInflater.from(requireContext()).inflate(R.layout.add_task_layout, null)
            val et_Name = view.findViewById<EditText>(R.id.et_task_name)


            AlertDialog.Builder(requireContext())
                .setView(view)
                .setTitle("Add Task")
                .setPositiveButton("Add") { _, _ ->
                    val name = et_Name.text.toString()
                    Toast.makeText(requireContext(), "$name", Toast.LENGTH_SHORT).show()
//                    list.add(name)
//                    adapter.notifyItemInserted(list.size - 1)

                }
                .setNegativeButton("Cancel") { _, _ -> }
                .show()

        }

    }

    private fun btmNavBarSetUp() {
        binding.bottomNavigationView.background = null
        binding.bottomNavigationView.menu.getItem(2).isEnabled = false
    }


    private fun rvUserListSetUp() {

        val UserNameList = listOf(
            "User 0 ",
            "User 1",
            "User 2",
            "User 3",
            "User 4",
            "User 5",
            "User 6",
            "User 7",
            "User 8"
        )
        val adapter = rvUserListAdapter(UserNameList, this)
        binding.rvUserList.adapter = adapter
        binding.rvUserList.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

    }

    override fun ClickedMember(user: String) {
        findNavController().navigate(R.id.action_f_Home_to_f_Tasks)
    }

}