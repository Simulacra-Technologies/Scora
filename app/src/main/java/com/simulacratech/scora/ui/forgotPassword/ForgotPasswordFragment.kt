package com.simulacratech.scora.ui.forgotPassword

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.simulacratech.scora.MainActivityViewModel
import com.simulacratech.scora.R
import com.simulacratech.scora.base.BaseFragment
import com.simulacratech.scora.base.BaseViewModel
import com.simulacratech.scora.databinding.FragmentForgotPasswordBinding
import com.simulacratech.scora.ui.appJourney.AppJourneyFragmentDirections

class ForgotPasswordFragment : BaseFragment<FragmentForgotPasswordBinding, ForgotPasswordViewModel>() {

    companion object {
        fun newInstance() = ForgotPasswordFragment()
    }

    override val viewModel: ForgotPasswordViewModel by viewModels()

    override fun getLayoutResId(): Int  = R.layout.fragment_forgot_password

    val mainActivityViewModel: MainActivityViewModel by activityViewModels()

    override fun getMaiViewModel() = mainActivityViewModel

    override fun init() {
        binding.btnBackToLogin.setOnClickListener {
            viewModel.navigate(ForgotPasswordFragmentDirections.actionForgotPasswordFragmentToLoginFragment())
        }
    }
}