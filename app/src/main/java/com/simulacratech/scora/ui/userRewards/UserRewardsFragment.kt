package com.simulacratech.scora.ui.userRewards

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.simulacratech.scora.MainActivityViewModel
import com.simulacratech.scora.R
import com.simulacratech.scora.base.BaseFragment
import com.simulacratech.scora.databinding.FragmentUserRewardsBinding

class UserRewardsFragment : BaseFragment<FragmentUserRewardsBinding, UserRewardViewModel>() {

    companion object {
        fun newInstance() = UserRewardsFragment()
    }

    override val viewModel: UserRewardViewModel by viewModels()

    val mainActivityViewModel: MainActivityViewModel by activityViewModels()

    override fun getLayoutResId(): Int = R.layout.fragment_user_rewards

    override fun getMaiViewModel() = mainActivityViewModel

    override fun init() {

    }


}