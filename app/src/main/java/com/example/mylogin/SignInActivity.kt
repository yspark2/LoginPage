package com.example.mylogin

import android.app.Instrumentation.ActivityResult
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.ActivityResultLauncher
import kotlin.random.Random

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val et_pw = findViewById<EditText>(R.id.et_pw)
        val btn_login = findViewById<Button>(R.id.btn_login)
        val et_login = findViewById<EditText>(R.id.et_login)

        val signUpActivityLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){result->
            if(result.resultCode == RESULT_OK){
                val data:Intent? = result.data
                val subIdTextValue = data?.getStringExtra("id")
                val subPwTextValue = data?.getStringExtra("pw")

                subIdTextValue?.let{
                    et_login.setText(it)
                }

                subPwTextValue.let{
                    et_pw.setText(it)
                }
            }
        }


        btn_login.setOnClickListener {
            if(!et_login.text.toString().trim().isEmpty() && !et_pw.text.toString().trim().isEmpty()){
                Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
                val info_id = "아이디: " + et_login.text.toString()
                // 버튼이 눌리면 EditText에 있는 내용 저장

                val intent = Intent(this, HomeActivity::class.java)
                // 인텐트 생성

                intent.putExtra("info_id", info_id)
//                et_login.setText(null)
//                et_pw.setText(null)

                startActivity(intent)

            }else{
                Toast.makeText(this,"아이디/비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show()
            }
        }
        val btn_join = findViewById<Button>(R.id.btn_join)
        val intent = Intent(this, SignUpActivity::class.java)

        btn_join.setOnClickListener {
            signUpActivityLauncher.launch(intent)
        }
    }


}