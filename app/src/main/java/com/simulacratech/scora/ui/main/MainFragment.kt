package com.simulacratech.scora.ui.main

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.simulacratech.scora.MainActivityViewModel
import com.simulacratech.scora.R
import com.simulacratech.scora.base.BaseFragment
import com.simulacratech.scora.base.BaseViewModel
import com.simulacratech.scora.databinding.FragmentMainBinding

class MainFragment : BaseFragment<FragmentMainBinding,MainViewModel>() {

    companion object {
        fun newInstance() = MainFragment()
    }

    val mainActivityViewModel: MainActivityViewModel by activityViewModels()

    override val viewModel: MainViewModel by viewModels()

    override fun getLayoutResId(): Int = R.layout.fragment_main

    override fun getMaiViewModel(): BaseViewModel = mainActivityViewModel

    override fun init() {

    }
}