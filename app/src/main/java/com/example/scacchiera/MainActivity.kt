package com.example.scacchiera

import android.annotation.TargetApi
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.widget.SeekBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        divisioniSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                // Display the current progress of SeekBar
                println("value i")
                println(i)
                println(b)
                DivisionitextView.text = "Divisioni : $i"
                schacchieraView.invalidate()
                divisioni=i
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // Do something
                //Toast.makeText(applicationContext,"start tracking",Toast.LENGTH_SHORT).show()
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                 

            }

        })
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            divisioniSeekBar.min=3
        }
        divisioniSeekBar.max= 8

    }
}
