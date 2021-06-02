package com.terra.awareapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.terra.awareapplication.databinding.FragmentChangePasswordBinding


class ChangePasswordFragment : Fragment() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: FragmentChangePasswordBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChangePasswordBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = FirebaseAuth.getInstance()

        val user = auth.currentUser

        binding.layoutPassword.visibility = View.VISIBLE
        binding.layoutNewPassword.visibility = View.GONE

        binding.btnAuth.setOnClickListener {
            val password = binding.etPassword.text.toString().trim()
            if (password.isEmpty()) {
                binding.etPassword.error = "Password Harus diisi"
                binding.etPassword.requestFocus()
                return@setOnClickListener
            }

            user?.let {
                val userCredential = EmailAuthProvider.getCredential(it.email!!, password)
                it.reauthenticate(userCredential).addOnCompleteListener {
                    if (it.isSuccessful) {
                        binding.layoutPassword.visibility = View.GONE
                        binding.layoutNewPassword.visibility = View.VISIBLE
                    } else if (it.exception is FirebaseAuthInvalidCredentialsException) {
                        binding.etPassword.error = "Wrong password"
                        binding.etPassword.requestFocus()
                    } else {
                        Toast.makeText(activity, "e${it.exception?.message}", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }

            binding.btnUpdate.setOnClickListener { view ->
                val newPassword = binding.etNewPassword.text.toString().trim()
                val newPasswordConfirm = binding.etNewPasswordConfirm.text.toString().trim()

                if (newPassword.isEmpty() || newPassword.length < 6) {
                    binding.etNewPassword.error = "Password must be more than 6 characters"
                    binding.etNewPassword.requestFocus()
                    return@setOnClickListener
                }

                if (newPassword != newPasswordConfirm) {
                    binding.etNewPasswordConfirm.error = "Passwords are not the same"
                    binding.etNewPasswordConfirm.requestFocus()
                    return@setOnClickListener
                }


                user?.let {
                    user.updatePassword(newPassword).addOnCompleteListener {
                        if (it.isSuccessful) {
                            val actionPasswordChanged =
                                ChangePasswordFragmentDirections.actionPasswordChange()
                            Navigation.findNavController(view).navigate(actionPasswordChanged)
                            Toast.makeText(
                                activity,
                                "Password changed successfully",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            Toast.makeText(activity, "${it.exception?.message}", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                }
            }
        }
    }


}