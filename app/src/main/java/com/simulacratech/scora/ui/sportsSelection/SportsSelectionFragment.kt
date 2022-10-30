package com.simulacratech.scora.ui.sportsSelection

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.simulacratech.scora.MainActivityViewModel
import com.simulacratech.scora.R
import com.simulacratech.scora.base.BaseFragment
import com.simulacratech.scora.base.Game
import com.simulacratech.scora.databinding.FragmentSportsSelectionBinding
import com.simulacratech.scora.layoutGame

class SportsSelectionFragment : BaseFragment<FragmentSportsSelectionBinding, SportsSelectionViewModel>() {

    var list = ArrayList<Any>()
    companion object {
        fun newInstance() = SportsSelectionFragment()
    }

    override val viewModel: SportsSelectionViewModel by viewModels()

    val mainActivityViewModel: MainActivityViewModel by activityViewModels()

    override fun getLayoutResId(): Int = R.layout.fragment_sports_selection

    override fun getMaiViewModel() = mainActivityViewModel

    override fun init() {
        list.add(Game("cricket"))
        binding.recyclerView.withModels {
            list.forEach{
                layoutGame {
                    id(0)
                    game(it as Game)
                    clickListener { model, parentView, clickedView, position ->
                        viewModel.navigate(
                            SportsSelectionFragmentDirections
                                .actionSportsSelectionFragmentToStartCricketMatchFragment()
                        )
                    }
                }
            }
        }

    }
}