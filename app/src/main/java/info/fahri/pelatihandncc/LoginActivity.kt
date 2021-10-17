package info.fahri.pelatihandncc

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        actionBar?.title = "Login Aplikasi"
        supportActionBar?.title = "Login Aplikasi"

        // val edtUsername: EditText = findViewById(R.id.edtUsername)
    }

    fun login(view: View){
        val it = Intent(this, FoodGridActivity::class.java)
        startActivity(it)
    }

    fun facebook(view: View){
        var inputan = edtUsername.text
        val it = Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/"+inputan))
        startActivity(it)
    }
}