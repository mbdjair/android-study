package com.djair.chucknorris.presentation.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.djair.chucknorris.R
import org.koin.androidx.viewmodel.ext.android.viewModel


class SplashFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_splash, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val model: SplashViewModel by viewModel()
        model.data.observe(viewLifecycleOwner, Observer {
            if (it) {
                findNavController().navigate(R.id.action_splash_to_home)
            }
        })
        model.initApp()
        super.onViewCreated(view, savedInstanceState)
    }

}