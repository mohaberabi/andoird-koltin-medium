package com.example.fragmenttrivia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.fragmenttrivia.databinding.FragmentTitleBinding

class TitleFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentTitleBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_title, container, false)


        // this was method 1 for navigation in fragments 
//        binding.playButton.setOnClickListener{
//            view :View ->
//            Navigation.findNavController(view).navigate(R.id.action_titleFragment_to_gameFragment)
//
//        }
        // this was method 2 for navigation in fragments  using an extension function was added to view class only for kotlin

        binding.playButton.setOnClickListener(Navigation.createNavigateOnClickListener(TitleFragmentDirections.actionTitleFragmentToGameFragment()))

        setHasOptionsMenu(true)


        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater.inflate(R.menu.overflow_menu,menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item,
            requireView().findNavController())|| super.onOptionsItemSelected(item)
    }

}