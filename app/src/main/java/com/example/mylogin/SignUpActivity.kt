package com.example.mylogin

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton

class SignUpActivity : AppCompatActivity() {

//    private val btn_join2: AppCompatButton by lazy { findViewById(R.id.btn_join2)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        var btn_join2 = findViewById<Button>(R.id.btn_join2)
        var et_name = findViewById<EditText>(R.id.et_name)
        var et_id2 = findViewById<EditText>(R.id.et_id2)
        var et_pw2 = findViewById<EditText>(R.id.et_pw2)
        btn_join2.setOnClickListener {
            if(et_name.text.toString().trim().isEmpty() || et_id2.text.toString().trim().isEmpty() ||
                    et_pw2.text.toString().trim().isEmpty()){
                Toast.makeText(this,"입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this, SignInActivity::class.java).apply{
                    putExtra("id", et_id2.text.toString())
                    putExtra("pw", et_pw2.text.toString())
                }
                setResult(RESULT_OK, intent)
                finish()
            }
        }
    }
}