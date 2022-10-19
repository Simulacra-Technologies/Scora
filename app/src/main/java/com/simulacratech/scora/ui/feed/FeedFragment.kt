package com.simulacratech.scora.ui.feed

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.simulacratech.scora.MainActivityViewModel
import com.simulacratech.scora.R
import com.simulacratech.scora.base.BaseFragment
import com.simulacratech.scora.databinding.FragmentFeedBinding
import com.simulacratech.scora.databinding.FragmentSignupBinding
import com.simulacratech.scora.ui.forgotPassword.ForgotPasswordFragmentDirections

class FeedFragment  : BaseFragment<FragmentFeedBinding, FeedViewModel>() {

    companion object {
        fun newInstance() = FeedFragment()
    }

    override val viewModel: FeedViewModel by viewModels()

    val mainActivityViewModel: MainActivityViewModel by activityViewModels()

    override fun getLayoutResId(): Int = R.layout.fragment_feed

    override fun getMaiViewModel() = mainActivityViewModel

    override fun init() {

    }


}