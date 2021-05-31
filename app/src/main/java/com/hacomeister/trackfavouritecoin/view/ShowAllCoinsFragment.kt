package com.hacomeister.trackfavouritecoin.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hacomeister.trackfavouritecoin.R
import com.hacomeister.trackfavouritecoin.TFCViewModelFactory
import com.hacomeister.trackfavouritecoin.viewmodel.ShowAllCoinsViewModel

class ShowAllCoinsFragment : Fragment() {

    private lateinit var viewModel: ShowAllCoinsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.show_all_coins_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this, TFCViewModelFactory).get(ShowAllCoinsViewModel::class.java)

        viewModel.getAllCoins()
    }
}