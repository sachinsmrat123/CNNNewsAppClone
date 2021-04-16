package com.example.cnn_news_app.view.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import com.example.cnn_news_app.MainActivity
import com.example.cnn_news_app.R
import com.example.cnn_news_app.ViewPagerAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home.*


@AndroidEntryPoint
class HomeFragment : Fragment() {
    private val TAG: String = HomeFragment::class.java.getSimpleName()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        viewPager.adapter = ViewPagerAdapter(requireActivity().supportFragmentManager)
        viewPager.adapter = ViewPagerAdapter(childFragmentManager)
        tabLayout.setupWithViewPager(viewPager)
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        printLogs("onAttach")
    }

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        printLogs("onCreate")
    }

    override fun onActivityCreated(@Nullable savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        printLogs("onActivityCreated")
    }


    override fun onStart() {
        super.onStart()
        printLogs("onStart")
    }

    override fun onResume() {

        super.onResume()
        printLogs("onResume")
    }

    override fun onPause() {
        super.onPause()
        printLogs("onPause")
    }

    override fun onStop() {
        super.onStop()
        printLogs("onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        printLogs("onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        printLogs("onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        printLogs("onDetach")
    }

    private fun printLogs(message: String) {
        Log.d(TAG, message)
    }

}