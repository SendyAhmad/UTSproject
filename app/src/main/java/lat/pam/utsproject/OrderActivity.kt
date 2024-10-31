package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OrderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        val foodNameEditText = findViewById<EditText>(R.id.etFoodName)
        val servingsEditText = findViewById<EditText>(R.id.etServings)
        val nameEditText = findViewById<EditText>(R.id.etName)
        val notesEditText = findViewById<EditText>(R.id.etNotes)
        val placeOrderButton = findViewById<Button>(R.id.btnOrder)

        // Mengambil nama makanan dari intent sebelumnya
        val foodName = intent.getStringExtra("foodName")
        foodNameEditText.setText(foodName)

        placeOrderButton.setOnClickListener {
            val servings = servingsEditText.text.toString()
            val orderingName = nameEditText.text.toString()
            val additionalNotes = notesEditText.text.toString()

            // Validasi input
            if (servings.isEmpty() || orderingName.isEmpty()) {
                Toast.makeText(this, "Jumlah porsi dan nama pemesan harus diisi", Toast.LENGTH_SHORT).show()
            } else {
                // Membuat intent untuk pindah ke ConfirmationActivity
                val intent = Intent(this, ConfirmationActivity::class.java).apply {
                    putExtra("foodName", foodName)
                    putExtra("servings", servings)
                    putExtra("orderingName", orderingName)
                    putExtra("additionalNotes", additionalNotes)
                }
                startActivity(intent)
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
