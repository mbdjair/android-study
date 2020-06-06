package com.djair.chucknorris.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.djair.chucknorris.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : Fragment() {
    lateinit var bind: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val model: HomeViewModel by viewModel()
        bind = FragmentHomeBinding.inflate(inflater, container, false)
        model.data.observe(viewLifecycleOwner, Observer {
            bind.model = it
        })
        model.loading.observe(viewLifecycleOwner, Observer {
            bind.loading = it
        })
        bind.button.setOnClickListener {
            model.newJoke()
        }
        return bind.root
    }

}