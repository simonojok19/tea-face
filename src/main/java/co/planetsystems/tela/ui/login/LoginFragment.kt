package co.planetsystems.tela.ui.login

import android.Manifest
import android.app.ProgressDialog
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import co.planetsystems.tela.R
import co.planetsystems.tela.common.VolleySingleton
import co.planetsystems.tela.common.TelaUrl.PHONE_VERIFICATION_URL
import co.planetsystems.tela.databinding.FragmentLoginBinding
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import org.json.JSONObject


class LoginFragment : Fragment() {
    lateinit var loginViewModel: LoginViewModel
    lateinit var phoneEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginViewModel = ViewModelProvider(this, LoginViewFactory(this)).get(LoginViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val binding: FragmentLoginBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        phoneEditText = binding.phoneNumber

        binding.vm = loginViewModel
        binding.lifecycleOwner = this

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        checkPermission()
    }

    override fun onResume() {
        super.onResume()
        val dialog = ProgressDialog(context)
        dialog.show()
        makeRequest()
    }

    private fun checkPermission() {
        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) { //Can add more as per requirement
            ActivityCompat.requestPermissions(requireActivity(), arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION),
                    123)
        }
    }

    private fun makeRequest() {
        val params = HashMap<String,String>()
        params["foo1"] = "bar1"
        params["foo2"] = "bar2"
        val jsonObject = JSONObject(params as Map<*, *>)

        val request = JsonObjectRequest(
                Request.Method.POST,
                PHONE_VERIFICATION_URL,
                jsonObject,
                { response ->
                    Log.d("Res", response.toString())
                }, { error ->
                    Log.d("Error", error.toString())
                }
        )

        VolleySingleton.getInstance(requireContext()).addToRequestQueue(request)
    }
}