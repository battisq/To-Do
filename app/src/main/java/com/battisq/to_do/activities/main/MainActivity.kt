package com.battisq.to_do.activities.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.battisq.to_do.R
import com.battisq.to_do.databinding.ActivityMainBinding
import com.battisq.to_do.utilits.MAIN_ACTIVITY
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mToolbar: Toolbar
    lateinit var mNavController: NavController
    lateinit var mMainActivityViewModel: MainActivityViewModel
    private var binding: ActivityMainBinding? = null
    val mBinding: ActivityMainBinding
        get() = binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    fun init() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        MAIN_ACTIVITY = this
        mToolbar = mBinding.toolbar
        mNavController = Navigation.findNavController(
            this,
            R.id.nav_host_fragment
        )
        setSupportActionBar(toolbar)

        mMainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        mMainActivityViewModel.initDatabase {  }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}