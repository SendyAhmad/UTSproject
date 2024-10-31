package lat.pam.utsproject

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etUsername = findViewById<EditText>(R.id.etUsername)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val tvRegister = findViewById<TextView>(R.id.tvRegister)

        // Mendapatkan SharedPreferences
        val sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)

        btnLogin.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            // Mengambil username dan password yang tersimpan
            val savedUsername = sharedPreferences.getString("username", null)
            val savedPassword = sharedPreferences.getString("password", null)

            // Validasi input
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Username atau password tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else {
                // Implementasi logika login
                if (username == savedUsername && password == savedPassword) {
                    Toast.makeText(this, "Login berhasil", Toast.LENGTH_SHORT).show()
                    // Navigasi ke ListFoodActivity jika login berhasil
                    val intent = Intent(this, ListFoodActivity::class.java)
                    startActivity(intent)
                    finish() // Menutup MainActivity jika login berhasil
                } else {
                    Toast.makeText(this, "Username atau password salah", Toast.LENGTH_SHORT).show()
                }
            }
        }

        // Navigasi ke activity register
        tvRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}
