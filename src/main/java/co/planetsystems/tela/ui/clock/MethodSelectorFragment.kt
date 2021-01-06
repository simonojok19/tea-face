package co.planetsystems.tela.ui.clock

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import co.planetsystems.tela.R
import co.planetsystems.tela.databinding.FragmentMethodSelectorBinding
import co.planetsystems.tela.ui.clock.face.FaceActivity

class MethodSelectorFragment : Fragment() {
    lateinit var  binding: FragmentMethodSelectorBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentMethodSelectorBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment

        setUpOnClickListeners()
        setUpConfigurations()
        return binding.root
    }

    private fun setUpConfigurations() {
        setHasOptionsMenu(true)
        val appCompatActivity = activity as AppCompatActivity
        appCompatActivity.setSupportActionBar(binding.toolBar)
    }

    private fun setUpOnClickListeners() {
        binding.faceCard.setOnClickListener {
            val action = MethodSelectorFragmentDirections
                    .actionMethodSelectorFragmentToFaceActivity("")
                    .setAction(FaceActivity.ACTION_CLOCK_IN)
            findNavController().navigate(action)
        }
    }
}