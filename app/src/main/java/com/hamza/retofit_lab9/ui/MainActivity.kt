package com.hamza.retofit_lab9.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.hamza.retofit_lab9.adapters.AdapterUsers
import com.hamza.retofit_lab9.databinding.ActivityMainBinding
import com.hamza.retofit_lab9.models.UserModel
 import com.hamza.retofit_lab9.network.RetofitConnection
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding !!
    val adapter = AdapterUsers()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding?.root)
        getUsers()
    }

    @SuppressLint("ShowToast")
    private fun getUsers() {
        lifecycleScope.launch  {

            val result = RetofitConnection.getRetrofit().getUsers()
            if (result.isSuccessful) {
                val users = result.body()?.data
                adapter.list= users as ArrayList<UserModel.Data>?
                binding .rv .adapter =adapter
            } else {
                Toast.makeText(this@MainActivity, "ERROR", Toast.LENGTH_LONG)
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding
    }
}