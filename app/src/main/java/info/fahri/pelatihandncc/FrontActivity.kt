package info.fahri.pelatihandncc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class FrontActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_front)
        supportActionBar?.hide()
    }

    fun login(view: View){
        val it = Intent(this, LoginActivity::class.java)
        startActivity(it)
    }
}