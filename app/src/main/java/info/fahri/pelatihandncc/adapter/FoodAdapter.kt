package info.fahri.pelatihandncc.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.annotations.SerializedName
import info.fahri.pelatihandncc.FoodDetailActivity
import info.fahri.pelatihandncc.R
import java.io.Serializable

class FoodAdapter(val dataset: ArrayList<Food>): RecyclerView.Adapter<FoodAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val txtItemFood: TextView
        val txtItemuser: TextView
        val txtItemTime: TextView
        val txtItemDesc: TextView
        val imgFood: ImageView
        val layoutItem: ConstraintLayout

        init {
            txtItemFood = itemView.findViewById(R.id.txtItemFood)
            txtItemuser = itemView.findViewById(R.id.txtItemUser)
            txtItemTime = itemView.findViewById(R.id.txtItemTime)
            txtItemDesc = itemView.findViewById(R.id.txtItemDesc)
            imgFood = itemView.findViewById(R.id.imgItemFood)
            layoutItem = itemView.findViewById(R.id.layoutItem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_food_grid, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtItemFood.text = dataset[position].name
        holder.txtItemuser.text = dataset[position].user
        holder.txtItemTime.text = dataset[position].cookTime.toString()+" menit"
        holder.txtItemDesc.text = dataset[position].desc
        holder.imgFood.setImageResource(R.drawable.hot_plate)

        holder.layoutItem.setOnClickListener{
            val context = holder.itemView.context
            val it = Intent(context, FoodDetailActivity::class.java)
            it.putExtra("food", dataset[position])
            context.startActivity(it)
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}

class Food: Serializable{
    @SerializedName("name")
    val name: String? = null
    @SerializedName("imageurl")
    val image: String? = null
    @SerializedName("user")
    val user: String? = null
    @SerializedName("cooktime")
    val cookTime: Int? = 0
    @SerializedName("desc")
    val desc: String? = null
}
