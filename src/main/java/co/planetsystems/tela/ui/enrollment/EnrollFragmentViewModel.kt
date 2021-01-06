package co.planetsystems.tela.ui.enrollment

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import co.planetsystems.tela.Repository
import co.planetsystems.tela.data.teacher.Teacher

class EnrollFragmentViewModel(application: Application): AndroidViewModel(application) {
    val repository: Repository = Repository.getInstance(application)


    val firstName = MutableLiveData<String>("")
    val lastName = MutableLiveData<String>("")
    val initials = MutableLiveData<String>("")
    val phoneNumber = MutableLiveData<String>("")
    val emailAddress = MutableLiveData<String>("")
    val nationalId = MutableLiveData<String>("")
    val gender = MutableLiveData<String>("")
    val isFaceCaptured = MutableLiveData(false)
    val isFingerCaptured = MutableLiveData(false)


    fun saveTeacher() {
        val fname = firstName.value ?: ""
        val lName = lastName.value ?: ""
        val ins = initials.value ?: ""
        val phone = phoneNumber.value ?: ""
        val email = emailAddress.value ?: ""
        val nation = nationalId.value ?: ""
        val gen = gender.value ?: ""

        val teacher = Teacher(
                firstName = fname,
                lastName = lName,
                initial = ins,
                phone = phone,
                email = email,
                nationalId = nation,
                gender = gen,
        )
        repository.enrollTeacher(teacher)
    }
}