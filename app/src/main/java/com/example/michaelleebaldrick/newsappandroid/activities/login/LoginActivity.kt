package com.example.michaelleebaldrick.newsappandroid.activities.login

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.michaelleebaldrick.newsappandroid.R
import com.example.michaelleebaldrick.newsappandroid.activities.newslist.NewsListActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var emailTxtBox: TextView
    private lateinit var passwordTxtBox: TextView
    private lateinit var incorrectDetailsLbl: TextView

    //TODO remove
    private val EXPECTED_EMAIL = "leebaldrick@gmail.com"
    private val EXPECTED_PASSWORD = "112233"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        this.emailTxtBox = findViewById(R.id.emailTxt)
        this.passwordTxtBox = findViewById(R.id.passwordTxt)
        this.incorrectDetailsLbl = findViewById(R.id.incorrectDetailsLbl)

        var clearBtn = findViewById<Button>(R.id.clearBtn)

        clearBtn.setOnClickListener {
            this.onClearBtnPressed()
        }

        var loginBtn = findViewById<Button>(R.id.loginBtn)

        loginBtn.setOnClickListener {
            this.onLoginBtnPressed(this)
        }
    }

    private fun onClearBtnPressed() {
        this.emailTxtBox.text = ""
        this.passwordTxtBox.text = ""
    }

    private fun onLoginBtnPressed(context: Context) {
        //TODO make server side call
        if (EXPECTED_EMAIL == this.emailTxtBox.text.trim().toString() && EXPECTED_PASSWORD  == this.passwordTxtBox.text.trim().toString()) {
            val intent = Intent(context, NewsListActivity::class.java)
            startActivity(intent)
        } else {
            incorrectDetailsLbl.visibility = View.VISIBLE
        }

    }
}
