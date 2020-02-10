package th.ac.su.bmime2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.time.Instant

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val btex = findViewById<Button>(R.id.btex)
        var sapab = findViewById<TextView>(R.id.sapab)
        var twobmi = findViewById<TextView>(R.id.twobmi)
        var hnw = findViewById<TextView>(R.id.hnw)
        val btnShare = findViewById<Button>(R.id.btnShare)




        val numbmi = intent.getStringExtra("numbmi")
        val bmi = intent.getDoubleExtra("bmi",0.0)
        val handw = intent.getStringExtra("handw")
        val h = intent.getDoubleExtra("h",-1.0)
        val w = intent.getDoubleExtra("w",-1.0)





        sapab.setText(numbmi)
        twobmi.setText(bmi.round(2).toString())
        hnw.setText("(height: "+h/100+" weight: "+w+ ")")









        btex.setOnClickListener {
            var Exit = Intent(this@DetailActivity,MainActivity::class.java)

            startActivity(Exit)
        }

        btnShare.setOnClickListener {

            var value = "My bmi is "+bmi.round(2)+" ("+numbmi+")"

            var intent     = Intent()
            intent.action  = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT,value)
            intent.type    = "text/plan"

            startActivity(Intent.createChooser(intent,"share Info"))

        }



    }




}
fun Double.round(decimals: Int): Double {
    var multiplier = 1.0
    repeat(decimals) { multiplier *= 10 }
    return kotlin.math.round(this * multiplier) / multiplier
}