package com.simulacratech.scora.ui.cricket.startInnings

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.simulacratech.scora.MainActivityViewModel
import com.simulacratech.scora.R
import com.simulacratech.scora.base.BaseFragment
import com.simulacratech.scora.databinding.FragmentStartInningsBinding

class StartInningsFragment : BaseFragment<FragmentStartInningsBinding, StartInningsViewModel>() {

    companion object {
        fun newInstance() = StartInningsFragment()
    }

    override val viewModel: StartInningsViewModel by viewModels()

    val mainActivityViewModel: MainActivityViewModel by activityViewModels()

    override fun getLayoutResId(): Int = R.layout.fragment_start_innings

    override fun getMaiViewModel() = mainActivityViewModel

    override fun init() {
        binding.btnNavigateToStartScoring.setOnClickListener {
            viewModel.navigate(
                StartInningsFragmentDirections.actionStartInningsFragmentToScoringFragment()
            )
        }
    }


}