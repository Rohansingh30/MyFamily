package com.blogspot.softwareengineerrohan.myfamilysafe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.blogspot.softwareengineerrohan.myfamilysafe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy {
    ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)




        replaceFragments(HomeFragment())
        binding.bottomBar.setOnItemSelectedListener {

            when(it.itemId){
                R.id.home -> {
                    replaceFragments(HomeFragment())
                }
                R.id.security -> {
                    replaceFragments(GuardFragment())

                }
                R.id.dashboard -> {
                    replaceFragments(DashboardFragment())

                }
                R.id.profile -> {
                    replaceFragments(ProfileFragment())

                }
                else -> {

                }
            }
            true
        }





    }

    fun replaceFragments(fragment: Fragment){
    val fragmentManager = supportFragmentManager
    val fragmentTransaction = fragmentManager.beginTransaction()
    fragmentTransaction.replace(R.id.frame_layout, fragment)
    fragmentTransaction.commit()
    }
}