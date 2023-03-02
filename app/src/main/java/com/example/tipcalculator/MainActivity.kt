package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tipcalculator.databinding.ActivityMainBinding
import kotlin.jvm.internal.Intrinsics.Kotlin
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCompute.setOnClickListener{
            computeBill()
        }

    }

    private fun computeBill() {
        val cost = binding.etCost.text.toString().toDoubleOrNull()
        if(cost == null){
            binding.tvBill.text = ""
            return ;
        }
        val tipPercent = when(binding.tipOptions.checkedRadioButtonId){
            R.id.amazing->0.20
            R.id.good->0.18
            else->0.15
        }
        var tip = tipPercent*cost
        if(binding.roundUpSwitch.isChecked){
            tip = tip.roundToInt().toDouble()
        }
        binding.tvBill.text = "Tip Amount: $$tip"
    }
}