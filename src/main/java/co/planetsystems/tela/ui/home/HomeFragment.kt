package co.planetsystems.tela.ui.home

import android.os.Bundle
import android.text.style.TtsSpan
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import co.planetsystems.tela.R
import co.planetsystems.tela.databinding.FragmentHomeBinding
import co.planetsystems.tela.ui.clock.clock_in.EmployeeNumberClockInDialog


class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    lateinit var clockInCardView: CardView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        clockInCardView = binding.clockInCardView

        setHasOptionsMenu(true)
        val appCompatActivity = activity as AppCompatActivity
        appCompatActivity.setSupportActionBar(binding.toolBar)

        clockInCardView.setOnClickListener {
           handleClockInClick()
        }

        return binding.root
    }

    private fun handleClockInClick() {
        findNavController().navigate(R.id.action_home_to_select_method_fragement)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.home_action_bar, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.action_enroll) {
            findNavController().navigate(R.id.action_homeFragment_to_enrollFragment)
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}