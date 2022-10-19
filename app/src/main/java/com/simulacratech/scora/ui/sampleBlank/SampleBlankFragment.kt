package com.simulacratech.scora.ui.sampleBlank

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.simulacratech.scora.MainActivityViewModel
import com.simulacratech.scora.R
import com.simulacratech.scora.base.BaseFragment
import com.simulacratech.scora.databinding.FragmentSampleBlankBinding
import com.simulacratech.scora.databinding.FragmentSignupBinding
import com.simulacratech.scora.ui.signup.SignupFragment
import com.simulacratech.scora.ui.signup.SignupFragmentDirections
import com.simulacratech.scora.ui.signup.SignupViewModel

class SampleBlankFragment : BaseFragment<FragmentSampleBlankBinding, SampleBlankViewModel>() {

    companion object {
        fun newInstance() = SampleBlankFragment()
    }

    override val viewModel: SampleBlankViewModel by viewModels()

    val mainActivityViewModel: MainActivityViewModel by activityViewModels()

    override fun getLayoutResId(): Int = R.layout.fragment_sample_blank

    override fun getMaiViewModel() = mainActivityViewModel

    override fun init() {

    }


}