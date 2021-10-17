package info.fahri.pelatihandncc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import info.fahri.pelatihandncc.adapter.Food
import kotlinx.android.synthetic.main.activity_food_detail.*
import java.lang.Exception


class FoodDetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_detail)

        val it = intent
        val food: Food = it.getSerializableExtra("food") as Food

        txtDetailFood.text = food.name
        txtDetailAlamat.text = "Pendrikan Kidul, Semarang"
        txtDetailMenit.text = food.cookTime.toString()+" menit"
        txtDetailUser.text = food.user
        txtDetailDesc.text = food.desc

        Picasso.get().load(food.image)
            .placeholder(R.drawable.sop_daging)// bisa diganti dengan gambar no-image
            .error(R.drawable.hot_plate)// diganti dengan gambar image broken
            .into(imgDetailFood, object: Callback{
                override fun onSuccess(){}

                override fun onError(e: Exception?) {
                    Log.e("Picasso", e.toString())
                }
            })
    }
}