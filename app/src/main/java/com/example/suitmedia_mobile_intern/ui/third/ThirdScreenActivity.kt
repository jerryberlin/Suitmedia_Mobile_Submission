package com.example.suitmedia_mobile_intern.ui.third

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.suitmedia_mobile_intern.R
import com.example.suitmedia_mobile_intern.adapter.UserListAdapter
import com.example.suitmedia_mobile_intern.databinding.ActivityThirdScreenBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ThirdScreenActivity : AppCompatActivity() {
    private val thirdScreenViewModel: ThirdScreenViewModel by viewModels()
    private lateinit var binding: ActivityThirdScreenBinding
    private lateinit var adapter: UserListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        binding.toolbarScreen.toolbar.findViewById<TextView>(R.id.textView).text =
            getString(R.string.third_screen)
        binding.toolbarScreen.toolbar.findViewById<Button>(R.id.backBtn).setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        val layoutManager = LinearLayoutManager(this)
        binding.thirdUserRV.layoutManager = layoutManager
        binding.thirdUserRV.setHasFixedSize(true)

        adapter = UserListAdapter()

        thirdScreenViewModel.getUsers().observe(this) {
            adapter.submitData(lifecycle, it)
            checkEmpty()
        }

        binding.swipeRefresher.setOnRefreshListener {
            thirdScreenViewModel.getUsers().observe(this) {
                adapter.submitData(lifecycle, it)
                checkEmpty()
            }
            binding.swipeRefresher.isRefreshing = false
        }

        binding.thirdUserRV.adapter = adapter
    }

    private fun checkEmpty() {
        adapter.addLoadStateListener { loadState ->
            if (loadState.refresh is LoadState.Loading) {
                binding.progressBar.visibility = View.VISIBLE
                binding.emptyTV.visibility = View.GONE
                binding.thirdUserRV.visibility = View.GONE
                binding.swipeRefresher.visibility = View.GONE
            } else {
                val isEmpty = adapter.itemCount == 0
                if (isEmpty) {
                    binding.emptyTV.visibility = View.VISIBLE
                    binding.thirdUserRV.visibility = View.GONE
                    binding.swipeRefresher.visibility = View.GONE
                    binding.progressBar.visibility = View.GONE
                } else {
                    binding.emptyTV.visibility = View.GONE
                    binding.thirdUserRV.visibility = View.VISIBLE
                    binding.swipeRefresher.visibility = View.VISIBLE
                    binding.progressBar.visibility = View.GONE
                }
            }
        }
    }
}