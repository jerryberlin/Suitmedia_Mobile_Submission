package com.example.suitmedia_mobile_intern.ui.second

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.suitmedia_mobile_intern.R
import com.example.suitmedia_mobile_intern.databinding.ActivitySecondScreenBinding
import com.example.suitmedia_mobile_intern.ui.third.ThirdScreenActivity
import com.example.suitmedia_mobile_intern.utils.Constants.USERNAME
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SecondScreenActivity : AppCompatActivity() {
    private val secondScreenViewModel: SecondScreenViewModel by viewModels()
    private lateinit var binding: ActivitySecondScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        binding.toolbarScreen.toolbar.findViewById<TextView>(R.id.textView).text =
            getString(R.string.second_screen)
        binding.toolbarScreen.toolbar.findViewById<Button>(R.id.backBtn).setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        secondScreenViewModel.getSession().observe(this) {
            binding.nameTV.text = it.name
        }

        val username = intent.getStringExtra(USERNAME)
        if (!username.isNullOrEmpty()) {
            binding.usernameTV.text = username
        }

        binding.chooseBtn.setOnClickListener {
            chooseBtnClicked()
        }
    }

    private fun chooseBtnClicked() {
        val toThirdScreen = Intent(this, ThirdScreenActivity::class.java)
        startActivity(toThirdScreen)
    }
}