package com.example.suitmedia_mobile_intern.ui.first

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.suitmedia_mobile_intern.core.model.UserSession
import com.example.suitmedia_mobile_intern.databinding.ActivityFirstScreenBinding
import com.example.suitmedia_mobile_intern.ui.second.SecondScreenActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstScreenActivity : AppCompatActivity() {
    private val firsScreenViewModel: FirstScreenViewModel by viewModels()
    private lateinit var binding: ActivityFirstScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFirstScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        supportActionBar?.hide()

        binding.checkBtn.setOnClickListener {
            checkBtnClicked()
        }
        binding.nextBtn.setOnClickListener {
            nextBtnClicked()
        }
    }

    private fun nextBtnClicked() {
        val name = binding.nameET.text.toString()
        if (name.isEmpty()) {
            binding.nameET.requestFocus()
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(binding.nameET, InputMethodManager.SHOW_IMPLICIT)
        } else {
            val toSecondScreen = Intent(this, SecondScreenActivity::class.java)
            startActivity(toSecondScreen)
            firsScreenViewModel.saveSession(
                UserSession(
                    name
                )
            )
        }
    }

    private fun checkBtnClicked() {
        if (checkPalindrome()) {
            Toast.makeText(this, "isPalindrome", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "not palindrome", Toast.LENGTH_SHORT).show()
        }
    }

    private fun checkPalindrome(): Boolean {
        val text = binding.palindromeET.text.toString()
        val cleanText = text.replace("[^a-zA-Z0-9]".toRegex(), "").lowercase()

        if (cleanText.isEmpty()) {
            return false
        }

        for (i in 0 until cleanText.length / 2) {
            if (cleanText[i] != cleanText[cleanText.length - i - 1]) {
                return false
            }
        }
        return true
    }
}