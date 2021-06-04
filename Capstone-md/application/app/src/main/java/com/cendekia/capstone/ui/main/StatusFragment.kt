package com.cendekia.capstone.ui.main

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.cendekia.capstone.R
import com.cendekia.capstone.databinding.FragmentStatusBinding
import com.cendekia.capstone.ui.mitigation.MitigationActivity
import java.text.SimpleDateFormat
import java.util.*

class StatusFragment : Fragment(R.layout.fragment_status) {

    private lateinit var binding: FragmentStatusBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStatusBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buildingState()

        binding.buttonMitigationSafe.setOnClickListener{
            val showStep = Intent(activity, MitigationActivity::class.java)
            startActivity(showStep)
        }
    }

    private fun buildingState() {

        val richterScale1 = (0..13).random()
        val richterScale2 = (0..13).random()

        val red = ResourcesCompat.getColor(resources, R.color.main_red, null)
        val green = ResourcesCompat.getColor(resources, R.color.main_green, null)
        val yellow = ResourcesCompat.getColor(resources, R.color.colorAccent, null)

        val average = (richterScale1 + richterScale2) / 2

        when {
            richterScale1 <= 3 && richterScale2 <= 3 -> {
                val safeAverageRs = resources.getString(R.string.richter_scale, average)
                binding.statusLayout.setBackgroundColor(green)
                Glide.with(this)
                    .load(R.drawable.icon_safe)
                    .apply(RequestOptions().override(200, 200))
                    .into(binding.icon)
                binding.tvSr.text = "$safeAverageRs SR"
                binding.tvDate.text = getCurrentDateTime().toString()
                binding.subTitle.text = "“Safe area.”"
            }
            richterScale1 in 3..6 && richterScale2 in 3..6 -> {
                val safeAverageRs = resources.getString(R.string.richter_scale, average)
                binding.statusLayout.setBackgroundColor(yellow)
                Glide.with(this)
                    .load(R.drawable.icon_warning)
                    .apply(RequestOptions().override(200, 200))
                    .into(binding.icon)
                binding.tvSr.text = "$safeAverageRs SR"
                binding.tvDate.text = getCurrentDateTime().toString()
                binding.subTitle.text = "“There is a sign of earthquake.”"
            }
            richterScale1 >= 6 && richterScale2 >= 6 -> {
                val safeAverageRs = resources.getString(R.string.richter_scale, average)
                binding.statusLayout.setBackgroundColor(red)
                Glide.with(this)
                    .load(R.drawable.icon_hazard)
                    .apply(RequestOptions().override(200, 200))
                    .into(binding.icon)
                binding.tvSr.text = "$safeAverageRs SR"
                binding.tvDate.text = getCurrentDateTime().toString()
                binding.subTitle.text = "“There is an earthquake.”"
            }
            else -> {
                binding.statusLayout.setBackgroundColor(green)
                Glide.with(this)
                    .load(R.drawable.icon_safe)
                    .apply(RequestOptions().override(200, 200))
                    .into(binding.icon)
                binding.tvSr.text = "Not an earthquake"
                binding.tvDate.text = getCurrentDateTime().toString()
                binding.subTitle.text = "“Safe area.”"
            }
        }
    }


    fun getCurrentDateTime(): Date {
        return Calendar.getInstance().time
    }
}