package com.example.cnn_news_app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val homeFragment = HomeFragment()
//        val profileFragment = ProfileFragment()
//        val savedFragment = SavedFragment()
//        val searchFragment = SearchFragment()
//
//        setCurrentFragment(homeFragment)
//
//        bottomNavigationView.setOnNavigationItemSelectedListener {
//            when(it.itemId){
//
//                R.id.homeFragment->setCurrentFragment(homeFragment)
//                R.id.searchFragment->setCurrentFragment(searchFragment)
//                R.id.savedFragment->setCurrentFragment(savedFragment)
//                R.id.profileFragment->setCurrentFragment(profileFragment)
//
//            }
//            true
//        }


        navController = findNavController(R.id.navHostFragmentContainer)
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment,
                R.id.searchFragment,
                R.id.savedFragment,
                R.id.profileFragment
            )
        )

        bottomNavigationView.setupWithNavController(navController)
        setSupportActionBar(toolBar)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }



//    private fun setCurrentFragment(fragment: Fragment)=
//        supportFragmentManager.beginTransaction().apply {
//            replace(R.id.navHostFragmentContainer,fragment)
//            commit()
//        }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

}