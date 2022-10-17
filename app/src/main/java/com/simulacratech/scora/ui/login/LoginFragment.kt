package com.simulacratech.scora.ui.login

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.simulacratech.scora.MainActivityViewModel
import com.simulacratech.scora.R
import com.simulacratech.scora.base.BaseFragment
import com.simulacratech.scora.base.BaseViewModel
import com.simulacratech.scora.databinding.FragmentLoginBinding

class LoginFragment : BaseFragment<FragmentLoginBinding,LoginViewModel>() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    val mainActivityViewModel : MainActivityViewModel by activityViewModels()

    override val viewModel: LoginViewModel by viewModels()

    override fun getLayoutResId(): Int  = R.layout.fragment_login

    override fun getMaiViewModel() = mainActivityViewModel

    override fun init() {
        binding.btnNavigateToSignup.setOnClickListener{
            LoginFragmentDirections.actionLoginFragmentToSignupFragment()
        }

        binding.btnNavigateToForgotPassword.setOnClickListener{
            LoginFragmentDirections.actionLoginFragmentToForgotPasswordFragment()
        }
    }

}