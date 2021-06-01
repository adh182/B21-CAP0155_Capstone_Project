package com.cendekia.capstone.ui.mitigation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cendekia.capstone.databinding.ActivityMitigationBinding
import com.cendekia.capstone.ui.main.HomeActivity
import com.cendekia.capstone.ui.main.StatusFragment

class MitigationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMitigationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMitigationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fab.setOnClickListener {
            val back = Intent(this, HomeActivity::class.java)
            startActivity(back)
        }
    }
}