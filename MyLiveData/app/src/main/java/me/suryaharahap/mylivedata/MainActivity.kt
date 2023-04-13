package me.suryaharahap.mylivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import me.suryaharahap.mylivedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var liveDataTimerViewModel: MainViewModel
    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        liveDataTimerViewModel = ViewModelProvider(this)[MainViewModel::class.java]
    }
}