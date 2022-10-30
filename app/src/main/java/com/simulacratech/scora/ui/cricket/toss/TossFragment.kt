package com.simulacratech.scora.ui.cricket.toss

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.simulacratech.scora.MainActivityViewModel
import com.simulacratech.scora.R
import com.simulacratech.scora.base.BaseFragment
import com.simulacratech.scora.databinding.FragmentTossBinding

class TossFragment : BaseFragment<FragmentTossBinding, TossViewModel>() {

    companion object {
        fun newInstance() = TossFragment()
    }

    override val viewModel: TossViewModel by viewModels()

    val mainActivityViewModel: MainActivityViewModel by activityViewModels()

    override fun getLayoutResId(): Int = R.layout.fragment_toss

    override fun getMaiViewModel() = mainActivityViewModel

    override fun init() {
        binding.btnNavigateToStartInnings.setOnClickListener {
            viewModel.navigate(
                TossFragmentDirections.actionTossFragmentToStartInningsFragment()
            )
        }
    }


}