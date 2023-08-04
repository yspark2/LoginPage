package com.example.mylogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val info_id = intent.getStringExtra("info_id")
        // intent.getStringExtra("전달했던 데이터의 이름표")
        val imgView1 = findViewById<ImageView>(R.id.imgView1)
        val tv_id = findViewById<TextView>(R.id.tv_id)
        rollDice()
        tv_id.text = info_id
        val btn_exit = findViewById<Button>(R.id.btn_exit)
        btn_exit.setOnClickListener {
            finish()
        }
    }

    fun rollDice(){
        val imgView1 = findViewById<ImageView>(R.id.imgView1)
        val random = Random
        val image = random.nextInt(6)
        val resultImage = when(image){
            0 -> R.drawable.animal1
            1 -> R.drawable.animal2
            2 -> R.drawable.animal3
            3 -> R.drawable.animal4
            4 -> R.drawable.animal5
            else -> R.drawable.animal6
        }
        // 이미지뷰 업데이트
        imgView1.setImageResource(resultImage)

        imgView1.contentDescription = image.toString()

    }


}