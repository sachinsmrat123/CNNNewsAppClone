package com.example.cnn_news_app.view.fragments

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cnn_news_app.R
import com.example.cnn_news_app.firebaseAuth.LoginActivity
import com.example.cnn_news_app.firebaseAuth.SignUpActivity
import com.example.cnn_news_app.liveTv.activity.liveTvActivity
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.fragment_profile.*

@AndroidEntryPoint
class ProfileFragment : Fragment() {
  var auth: FirebaseAuth? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth= FirebaseAuth.getInstance()
        val user = auth!!.currentUser
        if(user!=null){
            btLogin.text = "Log out"
            btLogin.setOnClickListener {
                val builder= AlertDialog.Builder(requireContext())
                builder.setTitle("Wait a sec...")
                builder.setMessage("Siging out from the device?\n\nYour data on this device will be deleted, " +
                        "but you can always get them back once you sign in again.")
                builder.setPositiveButton("SIGN OUT"){ dialog: DialogInterface?, which: Int ->
                    auth!!.signOut()
                    val intent = Intent(activity, LoginActivity::class.java)
                    startActivity(intent)
                   // requireActivity().finish()
                }
                builder.setNegativeButton("CANCEL"){dialogInterface, which ->
                }
                // Create the AlertDialog
                val alertDialog: AlertDialog = builder.create()
                // Set other dialog properties
                alertDialog.setCancelable(true)
                alertDialog.show()
            }
        }else{
            btLogin.setOnClickListener {
                val intent = Intent (activity, LoginActivity::class.java)
                startActivity(intent)
            }
        }
        btCreateAccount.setOnClickListener {
            val intent = Intent (activity, SignUpActivity::class.java)
            startActivity(intent)
        }

    }

}