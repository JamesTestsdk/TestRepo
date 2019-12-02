package com.example.sdktest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val lpSdkTest = LivePersonSdkTest(this)
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        val startButton: Button = findViewById(R.id.button)
        setContentView(R.layout.activity_main)
        
        //onClickListener set
        
        startButton.setOnClickListener{
            
            //Basic init called
            lpSdkTest.basicInitalization()

            // does not run in Fifth third project or emulator but will build on my personal phone
            // it does not need the other parameters such as campaign, engagement set and will connect without it
            //it just will not assign the conversation to a specific bot in live engage
            
        }
    }
}
