package com.simulacratech.scora.ui.teamSelectionFragment

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.simulacratech.scora.MainActivityViewModel
import com.simulacratech.scora.R
import com.simulacratech.scora.base.BaseFragment
import com.simulacratech.scora.base.Game
import com.simulacratech.scora.base.Team
import com.simulacratech.scora.databinding.FragmentTeamSelectionBinding
import com.simulacratech.scora.layoutGame
import com.simulacratech.scora.layoutTeam
import com.simulacratech.scora.ui.sportsSelection.SportsSelectionFragmentDirections

class TeamSelectionFragment : BaseFragment<FragmentTeamSelectionBinding, TeamSelectionViewModel>() {

    companion object {
        fun newInstance() = TeamSelectionFragment()
    }

    var list = ArrayList<Any>()

    override val viewModel: TeamSelectionViewModel by viewModels()

    val mainActivityViewModel: MainActivityViewModel by activityViewModels()

    override fun getLayoutResId(): Int = R.layout.fragment_team_selection

    override fun getMaiViewModel() = mainActivityViewModel

    override fun init() {
        list.add(Team(1,"Team a","Akash","https://en.wikipedia.org/wiki/Mumbai_Indians#/media/File:Mumbai_Indians_Logo.svg"))
        list.add(Team(2,"Team b","Akshay",""))
        list.add(Team(3,"Team c","Aman",""))
        list.add(Team(4,"Team d","Anil",""))

        binding.recyclerView.clear()
        binding.recyclerView.withModels {
            list.forEachIndexed { index, any ->
                layoutTeam {
                    id(index)
                    team(any as Team)
                }
            }
        }
    }


}