package com.example.cnn_news_app


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.cnn_news_app.view.fragments.ProfileFragment
import com.example.cnn_news_app.view.fragments.SavedFragment
import com.example.cnn_news_app.view.fragments.SearchFragment
import com.example.cnn_news_app.view.fragments.category.*

class ViewPagerAdapter(fm:FragmentManager):FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when(position){
            0->{
                TopNewsFragment()
            }
            1->{
                WorldFragment()
            }
            2->{
                UsPoliticsFragment()
            }
            3->{
                BusinessFragment()
            }
            4->{
                HealthFragment()
            }
            5->{
                EntertainmentFragment()
            }
            6->{
                SportsFragment()
            }
            else ->{
                TopNewsFragment()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position){
            0 ->{return "Top News"}
            1 ->{return "World"}
            2 ->{return "U.S. Politics"}
            3 ->{return "Business"}
            4 ->{return "Health"}
            5 ->{return "Entertainment"}
            6 ->{return "Sports"}

        }
        return super.getPageTitle(position)
    }

    override fun getCount(): Int {
        return 7;
    }


}