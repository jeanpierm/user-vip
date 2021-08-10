package com.example.user_vip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.user_vip.UserVipApplication.Companion.prefs
import com.example.user_vip.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUi()
    }

    private fun initUi() {
        binding.buttonLogout.setOnClickListener {
            prefs.wipe()
            onBackPressed()
        }
        binding.textName.text = "Bienvenido ${prefs.getName()}"
        if (prefs.getVip()) {
            setVipColorBg()
        }
    }

    private fun setVipColorBg() {
        binding.container.setBackgroundColor(ContextCompat.getColor(this, R.color.vip_yellow))
    }
}