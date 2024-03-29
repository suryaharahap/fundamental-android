package me.suryaharahap.mylivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
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
        subscribe()
    }

    private fun subscribe() {
        var elapsedTimeObserver = Observer<Long?> { along ->
            val newText = this@MainActivity.resources.getString(R.string.seconds, along)
            activityMainBinding.timerTextview.text = newText
        }

        liveDataTimerViewModel.getElapsedTime().observe(this, elapsedTimeObserver)
    }
}