package com.simulacratech.scora.ui.playerSelectionFragment

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.simulacratech.scora.MainActivityViewModel
import com.simulacratech.scora.R
import com.simulacratech.scora.base.BaseFragment
import com.simulacratech.scora.base.Game
import com.simulacratech.scora.databinding.FragmentPlayerSelectionBinding
import com.simulacratech.scora.ui.sportsSelection.SportsSelectionFragmentDirections

class PlayerSelectionFragment : BaseFragment<FragmentPlayerSelectionBinding, PlayerSelectionViewModel>() {

    companion object {
        fun newInstance() = PlayerSelectionFragment()
    }

    var list = ArrayList<Any>()

    override val viewModel: PlayerSelectionViewModel by viewModels()

    val mainActivityViewModel: MainActivityViewModel by activityViewModels()

    override fun getLayoutResId(): Int = R.layout.fragment_team_selection

    override fun getMaiViewModel() = mainActivityViewModel

    override fun init() {
        list.add(Game("cricket"))
        binding.recyclerView.withModels {
            list.forEach{

            }
        }
    }


}