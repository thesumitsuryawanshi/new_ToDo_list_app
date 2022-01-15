package com.example.todolistassignment.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.todolistassignment.Home
import com.example.todolistassignment.R
import com.example.todolistassignment.databinding.FragmentSignupBinding
import com.google.firebase.auth.FirebaseAuth

class SignUpFragment : Fragment() {

    private var _binding: FragmentSignupBinding? = null
    lateinit var mAuth: FirebaseAuth


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSignupBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        setSupportActionBar(binding.toolbar)

        binding.btnSignUp.setOnClickListener {
            val id = binding.etGmailid.text.toString()
            val pass = binding.etPassword.text.toString()
            createUser(id, pass)
        }
    }


    private fun createUser(email: String, password: String) {
        mAuth = FirebaseAuth.getInstance()
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(requireActivity()) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val name = binding.etName.text.toString()
                    Toast.makeText(
                        activity,
                        "Account created successfully. \n Welcome $name",
                        Toast.LENGTH_SHORT
                    ).show()

                    startActivity(Intent(activity, Home::class.java))
                    getActivity()?.onBackPressed()
                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(
                        activity, "Something went wrong.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}