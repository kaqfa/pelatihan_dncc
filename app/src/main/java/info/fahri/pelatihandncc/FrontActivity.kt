package info.fahri.pelatihandncc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class FrontActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_front)

        // nullable
        supportActionBar?.hide()

        // immutable
        val nilai1: Int = 90
        // mutable
        var nilai2: Int = 20

        // dynamic declaration
        val hasil = hitung(nilai1, nilai2)
    }

    fun login(view: View){
        val it = Intent(this, LoginActivity::class.java)
        startActivity(it)
    }

}

/*
* untuk membuat fungsi fun nama_fungsi(parameter): tipe_kembalian { body fungsi }
* */
fun hitung(nilai1: Int, nilai2: Int): Int{
    return nilai1+nilai2
}