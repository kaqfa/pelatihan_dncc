package info.fahri.pelatihandncc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import info.fahri.pelatihandncc.adapter.Food
import info.fahri.pelatihandncc.adapter.FoodAdapter
import java.util.*
import kotlin.collections.ArrayList

class FoodGridActivity : AppCompatActivity() {
    private lateinit var foodList: ArrayList<Food>
    private lateinit var rvFoodList: RecyclerView
    private lateinit var foodAdapter: FoodAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_grid)

        foodList = prepopulateData()
        foodAdapter = FoodAdapter(foodList)

        rvFoodList = findViewById(R.id.rvFoodList)
        rvFoodList.layoutManager = LinearLayoutManager(this)
        rvFoodList.itemAnimator = DefaultItemAnimator()
        rvFoodList.adapter = foodAdapter
    }

    private fun prepopulateData(): ArrayList<Food>{
        val jsonStream = resources.openRawResource(R.raw.sample_data)
        val jsonString = Scanner(jsonStream).useDelimiter("\\A").next()
        // Log.i("FOOD_GRID", jsonString)

        val gson = Gson()
        val sType = object : TypeToken<ArrayList<Food>>() {}.type
        return gson.fromJson<ArrayList<Food>>(jsonString, sType)
    }
}