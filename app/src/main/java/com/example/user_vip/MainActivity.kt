package com.example.user_vip

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.user_vip.UserVipApplication.Companion.prefs
import com.example.user_vip.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUi()
        checkUserValues()
    }

    private fun checkUserValues() {
        if (prefs.getName().isEmpty()) return
        goToDetail()

    }

    private fun initUi() {
        binding.btnContinue.setOnClickListener { accessToDetail() }
    }

    private fun accessToDetail() {
        val name = binding.editName.text.toString();
        val vip = binding.checkVip;

        if (name.isEmpty()) return

        prefs.saveName(name)
        prefs.saveVip(vip.isChecked)
        goToDetail()
    }

    private fun goToDetail() {
        startActivity(Intent(this, ResultActivity::class.java))
    }
}