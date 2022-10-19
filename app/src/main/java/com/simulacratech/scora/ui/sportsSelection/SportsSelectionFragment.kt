package com.simulacratech.scora.ui.sportsSelection

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.simulacratech.scora.MainActivityViewModel
import com.simulacratech.scora.R
import com.simulacratech.scora.base.BaseFragment
import com.simulacratech.scora.databinding.FragmentSampleBlankBinding
import com.simulacratech.scora.databinding.FragmentSportsSelectionBinding

class SportsSelectionFragment : BaseFragment<FragmentSportsSelectionBinding, SportsSelectionViewModel>() {

    companion object {
        fun newInstance() = SportsSelectionFragment()
    }

    override val viewModel: SportsSelectionViewModel by viewModels()

    val mainActivityViewModel: MainActivityViewModel by activityViewModels()

    override fun getLayoutResId(): Int = R.layout.fragment_sports_selection

    override fun getMaiViewModel() = mainActivityViewModel

    override fun init() {

    }


}