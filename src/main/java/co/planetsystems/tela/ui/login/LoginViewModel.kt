package co.planetsystems.tela.ui.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException
import org.json.JSONObject
import java.net.InetAddress
import java.util.*
import java.util.concurrent.Callable
import java.util.concurrent.ExecutionException
import java.util.concurrent.Executors


class LoginViewModel() : ViewModel() {
    private val TAG: String = "LoginViewModel"
    val phoneNumber = MutableLiveData<String>("")
    val phoneNumberErrors = MutableLiveData<String>()




    fun loginUser() {
        val phone: String = phoneNumber.value.toString()
        if(phone.startsWith("078") || phone.startsWith("077")) {
            Log.d(TAG, "loginUser Correct $phone")
            phoneNumberErrors.postValue("")

            val connected: Boolean = try {
                isConnected() == true
            } catch (e: ExecutionException) {
                false
            }

            if (connected) {
                print("Connected")
            }
        } else {
            val errors = "Invalid Phone Number"
            phoneNumberErrors.postValue(errors)

        }

    }


    private fun isConnected(): Boolean? {
        val executors = Executors.newFixedThreadPool(4)

        val callable = Callable{
            val ipAddr = InetAddress.getByName("google.com")
            //You can replace it with your name
            return@Callable !ipAddr.equals("")
        }

        return executors.submit(callable).get()
    }



}