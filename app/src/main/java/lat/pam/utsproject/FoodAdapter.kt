package lat.pam.utsproject

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FoodAdapter(private val context: Context, private val foodList: List<Food>) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout_food, parent, false)
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food = foodList[position]
        holder.bind(food)

        // Set click listener untuk membuka OrderActivity dengan detail makanan
        holder.itemView.setOnClickListener {
            val intent = Intent(context, OrderActivity::class.java).apply {
                putExtra("foodName", food.name)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = foodList.size

    class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.foodName)
        private val descriptionTextView: TextView = itemView.findViewById(R.id.foodDescription)
        private val imageView: ImageView = itemView.findViewById(R.id.foodImage)

        fun bind(food: Food) {
            nameTextView.text = food.name
            descriptionTextView.text = food.description
            imageView.setImageResource(food.imageResId)
        }
    }
}
