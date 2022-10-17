package com.simulacratech.scora.ui.signup

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.simulacratech.scora.MainActivityViewModel
import com.simulacratech.scora.R
import com.simulacratech.scora.base.BaseFragment
import com.simulacratech.scora.databinding.FragmentSignupBinding
import com.simulacratech.scora.ui.forgotPassword.ForgotPasswordFragmentDirections

class SignupFragment  : BaseFragment<FragmentSignupBinding, SignupViewModel>() {

    companion object {
        fun newInstance() = SignupFragment()
    }

    override val viewModel: SignupViewModel by viewModels()

    val mainActivityViewModel: MainActivityViewModel by activityViewModels()

    override fun getLayoutResId(): Int = R.layout.fragment_signup

    override fun getMaiViewModel() = mainActivityViewModel

    override fun init() {
        binding.btnBackToLogin.setOnClickListener {
            viewModel.navigate(SignupFragmentDirections.actionSignupFragmentToLoginFragment())
        }
    }


}