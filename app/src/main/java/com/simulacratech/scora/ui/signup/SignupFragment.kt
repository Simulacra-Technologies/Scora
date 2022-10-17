package com.simulacratech.scora.ui.signup

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.simulacratech.scora.MainActivityViewModel
import com.simulacratech.scora.R
import com.simulacratech.scora.base.BaseFragment
import com.simulacratech.scora.databinding.FragmentSignupBinding

class SignupFragment  : BaseFragment<FragmentSignupBinding, SignupViewModel>() {

    companion object {
        fun newInstance() = SignupFragment()
    }

/*
    @Inject
    lateinit var viewModelFactory: LoginViewModelFactory
*/

    override val viewModel: SignupViewModel by viewModels()/*{
        SignupViewModel.provideFactory(
            viewModelFactory,
            args.isGuest
        )
    }*/

    val mainActivityViewModel: MainActivityViewModel by activityViewModels()

    override fun getLayoutResId(): Int = R.layout.fragment_signup

    override fun getMaiViewModel() = mainActivityViewModel

    override fun init() {

    }


}