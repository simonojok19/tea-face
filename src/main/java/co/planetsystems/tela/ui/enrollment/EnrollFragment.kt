package co.planetsystems.tela.ui.enrollment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import co.planetsystems.tela.R
import co.planetsystems.tela.databinding.FragmentEnrollBinding
import co.planetsystems.tela.ui.clock.face.FaceActivity

class EnrollFragment : Fragment() {
    lateinit var binding: FragmentEnrollBinding
    lateinit var viewModel: EnrollFragmentViewModel
    lateinit var nationalId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EnrollFragmentViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentEnrollBinding.inflate(inflater, container, false)
        setUpFragment()
        setUpListeners()
        // Inflate the layout for this fragment
        return binding.root
    }

    private fun setUpListeners() {
        binding.faceCard.setOnClickListener {
            viewModel.saveTeacher()

            val action = EnrollFragmentDirections
                    .actionEnrollFragmentToFaceActivity(viewModel.nationalId.value ?: "")
                    .setAction(FaceActivity.ACTION_ENROLL)

//            val action = Enrol
            findNavController().navigate(action)
        }
    }

    private fun setUpFragment() {
        setHasOptionsMenu(true)
        val appCompatActivity = activity as AppCompatActivity
        appCompatActivity.setSupportActionBar(binding.toolBar)
        binding.vm = viewModel

        binding.lifecycleOwner = this
    }
}