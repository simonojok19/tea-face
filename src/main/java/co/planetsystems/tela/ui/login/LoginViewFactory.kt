package co.planetsystems.tela.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class LoginViewFactory(private val activity: LoginFragment): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
           return LoginViewModel() as T
        }
        throw IllegalArgumentException("Uknown View Model Class")

    }
}