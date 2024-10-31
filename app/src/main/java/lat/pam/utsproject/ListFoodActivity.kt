package lat.pam.utsproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFoodActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FoodAdapter
    private lateinit var foodList: List<Food>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_food)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val foodList = listOf(
            Food("Sparkling Tea", "Teh bersoda menyegarkan dengan rasa buah", R.drawable.sparkling_tea),
            Food("Nasi Goreng", "Nasi goreng spesial dengan tambahan telur mata sapi", R.drawable.nasigoreng),
            Food("Mie Goreng", "Mie goreng lezat dengan rempah pilihan", R.drawable.mie_goreng),
            Food("Kopi Hitam", "Kopi hitam pekat dengan aroma khas Kapal Api", R.drawable.kopi_hitam),
            Food("Cheesecake", "Cheesecake manis dengan lapisan keju krim lembut", R.drawable.cheesecake),
            Food("Donut", "Donat lembut dengan topping susu dan gula halus", R.drawable.donut),
            Food("Cireng", "Cireng isi yang gurih dengan tekstur renyah", R.drawable.cireng),
            Food("Cappucino", "Cappuccino nikmat dibuat dari biji kopi premium", R.drawable.cappuchino),
            Food("Black Salad", "Salad dengan sayuran segar dan dressing spesial", R.drawable.black_salad),
            Food("Batagor", "Batagor renyah dengan saus kacang khas Bandung", R.drawable.batagor)
        )




        adapter = FoodAdapter(this, foodList)
        recyclerView.adapter = adapter
    }
}
