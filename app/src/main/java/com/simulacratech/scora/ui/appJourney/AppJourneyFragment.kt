package com.simulacratech.scora.ui.appJourney

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.simulacratech.scora.MainActivityViewModel
import com.simulacratech.scora.R
import com.simulacratech.scora.base.BaseFragment
import com.simulacratech.scora.base.BaseViewModel
import com.simulacratech.scora.databinding.FragmentAppJourneyBinding

class AppJourneyFragment : BaseFragment<FragmentAppJourneyBinding,AppJourneyViewModel>() {

    companion object {
        fun newInstance() = AppJourneyFragment()
    }

    override val viewModel: AppJourneyViewModel by viewModels()

    override fun getLayoutResId() = R.layout.fragment_app_journey

    val mainActivityViewModel: MainActivityViewModel by activityViewModels()

    override fun getMaiViewModel() = mainActivityViewModel

    override fun init() {
        binding.btnNavigate.setOnClickListener {
            viewModel.navigate(AppJourneyFragmentDirections.actionAppJourneyFragmentToLoginFragment())
        }
    }
}