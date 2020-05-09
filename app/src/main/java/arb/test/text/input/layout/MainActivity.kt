package arb.test.text.input.layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn.setOnClickListener {


            if(!user() || !pas())
                return@setOnClickListener

            Toast.makeText(applicationContext,"Welcome",Toast.LENGTH_SHORT).show()

        }


    }

    fun user() : Boolean{

        var username = tip_main_user.editText?.text.toString().trim()

        return when {

            username.isEmpty() -> {
                tip_main_user.error = "This field cannot be empty"
                false
            }
            username.length > 30 -> {
                tip_main_user.error = "The number of characters entered is more than allowed"
                false
            }
            else -> {
                tip_main_user.error = null
                true
            }
        }
    }


    fun pas() : Boolean{

        var Password = tip_main_password.editText?.text.toString().trim()

        return when {

            Password.isEmpty() -> {
                tip_main_password.error = "This field cannot be empty"
                false
            }
            Password.length < 4 && Password.length != null -> {
                tip_main_password.error = "Enter at least 4 characters"
                false
            }
            else -> {
                tip_main_password.error = null
                true
            }
        }
    }
}
