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
import com.example.todolistassignment.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private lateinit var auth: FirebaseAuth


    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
              super.onViewCreated(view, savedInstanceState)

        auth = FirebaseAuth.getInstance()
        binding.btnSignin.setOnClickListener {
            Toast.makeText(requireContext(), "signing in", Toast.LENGTH_SHORT).show()
            val emailid = binding.etGmailid.text.toString()
            val password = binding.etPassword.text.toString()

            SignInWithIdPass(emailid, password)

        }
    }
    private fun SignInWithIdPass(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(requireActivity()) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser

                    Toast.makeText(
                        activity,
                        "Sign in success. \n Welcome ${user?.email}",
                        Toast.LENGTH_SHORT
                    ).show()
                    startActivity(Intent(activity, Home::class.java))
                    binding.etGmailid.text.clear()
                    binding.etPassword.text.clear()
                    getActivity()?.onBackPressed()

                } else {
                    Toast.makeText(
                        activity, "Something went wrong.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }}

//        setSupportActionBar(binding.toolbar)
//
//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        menuInflater.inflate(R.menu.menu_main, menu)
//        return true
//    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        return when (item.itemId) {
//            R.id.action_settings -> true
//            else -> super.onOptionsItemSelected(item)
//        }
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}