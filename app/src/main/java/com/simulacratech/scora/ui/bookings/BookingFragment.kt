package com.simulacratech.scora.ui.bookings

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.simulacratech.scora.MainActivityViewModel
import com.simulacratech.scora.R
import com.simulacratech.scora.base.BaseFragment
import com.simulacratech.scora.databinding.FragmentBookingBinding

class BookingFragment : BaseFragment<FragmentBookingBinding, BookingViewModel>() {

    companion object {
        fun newInstance() = BookingFragment()
    }

    override val viewModel: BookingViewModel by viewModels()

    val mainActivityViewModel: MainActivityViewModel by activityViewModels()

    override fun getLayoutResId(): Int = R.layout.fragment_booking

    override fun getMaiViewModel() = mainActivityViewModel

    override fun init() {

    }


}