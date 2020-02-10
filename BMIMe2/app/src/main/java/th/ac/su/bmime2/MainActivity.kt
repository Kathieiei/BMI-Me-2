package th.ac.su.bmime2

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.time.Instant

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val BMI = findViewById<TextView>(R.id.BMI)
        val numBMI = findViewById<TextView>(R.id.numBMI)
        val edtw = findViewById<EditText>(R.id.edtw)
        val edth = findViewById<EditText>(R.id.edth)
        val Calbt = findViewById<Button>(R.id.Calbt)

        Calbt.setOnClickListener {

            var weight:Double = edtw.text.toString().toDouble()
            var hight:Double = edth.text.toString().toDouble()
            var result = 0.00
            var output:String = numBMI.text.toString()
            var PBMI:String = numBMI.text.toString()











            result = weight/((hight/100)*(hight/100))


            BMI.setText(result.toString())






            if (result<18.50){
                output = ("Underweight")
            } else if (result<=25){
                output = ("Healthy")
            }else if (result<=30){
                output = ("Overweight")
            }else if (result>30){
                output = ("Obese")
            }
            numBMI.setText(output)
            hideKeyboard()


            var intent = Intent(this@MainActivity,DetailActivity::class.java)

            intent.putExtra("bmi",BMI.text.toString().toDouble())
            intent.putExtra("numbmi",numBMI.text.toString())
            intent.putExtra("h",edth.text.toString().toDouble())
            intent.putExtra("w",edtw.text.toString().toDouble())




            startActivity(intent)



        }

    }
    fun Double.round(decimals: Int): Double {
        var multiplier = 1.0
        repeat(decimals) { multiplier *= 10 }
        return kotlin.math.round(this * multiplier) / multiplier
    }

    fun Activity.hideKeyboard() {
        hideKeyboard(currentFocus ?: View(this))
    }

    fun Context.hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

}
