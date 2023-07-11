package com.example.roommaster

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.roommaster.model.IDatabase
import com.example.roommaster.model.Sexo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.IO).launch {
            IDatabase.GetDataBase(this@MainActivity).SexoDAO().Add(Sexo(0, "Masculino"))
            var texto = IDatabase.GetDataBase(this@MainActivity).SexoDAO().Get().size.toString()
            runOnUiThread {
                Toast.makeText(
                    this@MainActivity,
                    texto
                    ,
                    Toast.LENGTH_SHORT
                ).show()

            }
        }
    }
}