package com.example.latihan

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var txAngka1: EditText
    private lateinit var txAngka2: EditText
    private lateinit var btnTambah: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        txAngka1 = findViewById(R.id.txAngka1)
        txAngka2 = findViewById(R.id.txAngka2)
        btnTambah = findViewById(R.id.btnTambah)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, Fragment1())
            .commit()

        btnTambah.setOnClickListener {
            val angka1 = txAngka1.text.toString().toIntOrNull() ?: 0
            val angka2 = txAngka2.text.toString().toIntOrNull() ?: 0
            val hasil = angka1 + angka2

            val fragment2 = Fragment2.newInstance("$angka1 + $angka2 = $hasil")

            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment2)
                .addToBackStack(null)
                .commit()
        }
    }
}