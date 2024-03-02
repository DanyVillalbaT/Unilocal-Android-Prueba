package co.edu.eam.unilocal_prueba.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import co.edu.eam.unilocal_prueba.R

class RegistroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
        Log.e("RegistroActivity", "onCreate()")
    }

    override fun onPause() {
        super.onPause()
        Log.e("RegistroActivity", "onPause()")
    }

    override fun onResume() {
        super.onResume()
        Log.e("RegistroActivity", "onResume()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("RegistroActivity", "onDestroy()")

    }
}