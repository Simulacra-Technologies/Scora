package com.simulacratech.scora.ui.cricket.startCricketMatch

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.simulacratech.scora.MainActivityViewModel
import com.simulacratech.scora.R
import com.simulacratech.scora.base.BaseFragment
import com.simulacratech.scora.databinding.FragmentSampleBlankBinding
import com.simulacratech.scora.databinding.FragmentStartCricketMatchBinding

class StartCricketMatchFragment : BaseFragment<FragmentStartCricketMatchBinding, StartCricketMatchViewModel>() {

    companion object {
        fun newInstance() = StartCricketMatchFragment()
    }

    override val viewModel: StartCricketMatchViewModel by viewModels()

    val mainActivityViewModel: MainActivityViewModel by activityViewModels()

    override fun getLayoutResId(): Int = R.layout.fragment_start_cricket_match

    override fun getMaiViewModel() = mainActivityViewModel

    override fun init() {
        binding.tvTeamA.setOnClickListener {
            viewModel.navigate(
                StartCricketMatchFragmentDirections
                    .actionStartCricketMatchFragmentToTeamSelectionFragment()
            )
        }
        binding.tvTeamB.setOnClickListener {
            viewModel.navigate(
                StartCricketMatchFragmentDirections
                    .actionStartCricketMatchFragmentToTeamSelectionFragment()
            )
        }
        binding.btnNavigateToMatchInfo.setOnClickListener {
            viewModel.navigate(
                StartCricketMatchFragmentDirections
                    .actionStartCricketMatchFragmentToCricketMatchInfoFragment()
            )
        }
    }


}