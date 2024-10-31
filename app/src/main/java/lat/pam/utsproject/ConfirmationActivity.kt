package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ConfirmationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation)

        // Mendapatkan referensi elemen UI
        val foodNameTextView = findViewById<TextView>(R.id.tvFoodName)
        val servingsTextView = findViewById<TextView>(R.id.tvServings)
        val orderingNameTextView = findViewById<TextView>(R.id.tvOrderingName)
        val additionalNotesTextView = findViewById<TextView>(R.id.tvAdditionalNotes)
        val backButton = findViewById<Button>(R.id.backtoMenu)

        // Mengambil data dari Intent
        val foodName = intent.getStringExtra("foodName")
        val servings = intent.getStringExtra("servings")
        val orderingName = intent.getStringExtra("orderingName")
        val additionalNotes = intent.getStringExtra("additionalNotes")

        // Menampilkan data pada TextView
        foodNameTextView.text = "Food Name: $foodName"
        servingsTextView.text = "Number of Servings: $servings pax"
        orderingNameTextView.text = "Ordering Name: $orderingName"
        additionalNotesTextView.text = "Additional Notes: $additionalNotes"

        // Kembali ke halaman menu utama
        backButton.setOnClickListener {
            val intent = Intent(this, ListFoodActivity::class.java)
            startActivity(intent)
            finish()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
