package co.planetsystems.tela.ui.splash

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import co.planetsystems.tela.MainActivityViewModel
import co.planetsystems.tela.R
import co.planetsystems.tela.common.CONFIGURATION


class SplashFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)

    }

    override fun onResume() {
        super.onResume()
        Handler().postDelayed(Runnable {
             findNavController().navigate(R.id.action_spash_to_home_fragment)
        }, CONFIGURATION.SPLASH_SCREEN_DURATION)
    }
}