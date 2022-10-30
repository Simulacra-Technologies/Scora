package com.simulacratech.scora.ui.cricket.cricketMatchInfo

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.simulacratech.scora.MainActivityViewModel
import com.simulacratech.scora.R
import com.simulacratech.scora.base.BaseFragment
import com.simulacratech.scora.databinding.FragmentCricketMatchInfoBinding
import com.simulacratech.scora.databinding.FragmentSampleBlankBinding

class CricketMatchInfoFragment : BaseFragment<FragmentCricketMatchInfoBinding, CricketMatchInfoViewModel>() {

    companion object {
        fun newInstance() = CricketMatchInfoFragment()
    }

    override val viewModel: CricketMatchInfoViewModel by viewModels()

    val mainActivityViewModel: MainActivityViewModel by activityViewModels()

    override fun getLayoutResId(): Int = R.layout.fragment_cricket_match_info

    override fun getMaiViewModel() = mainActivityViewModel

    override fun init() {
        binding.btnNavigateToToss.setOnClickListener {
            viewModel.navigate(
                CricketMatchInfoFragmentDirections
                    .actionCricketMatchInfoFragmentToTossFragment()
            )
        }
    }


}