package com.simulacratech.scora.ui.cricket.scoring

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.simulacratech.scora.MainActivityViewModel
import com.simulacratech.scora.R
import com.simulacratech.scora.base.Ball
import com.simulacratech.scora.base.BaseFragment
import com.simulacratech.scora.base.Wicket
import com.simulacratech.scora.databinding.FragmentScoringBinding
import com.simulacratech.scora.layoutBall

class ScoringFragment : BaseFragment<FragmentScoringBinding, ScoringViewModel>() {

    companion object {
        fun newInstance() = ScoringFragment()
    }

    override val viewModel: ScoringViewModel by viewModels()

    val mainActivityViewModel: MainActivityViewModel by activityViewModels()

    override fun getLayoutResId(): Int = R.layout.fragment_scoring

    override fun getMaiViewModel() = mainActivityViewModel

    var ballBowled = Ball()
    var list = ArrayList<Any>()

    override fun init() {
        viewModel.currentBall.observe(viewLifecycleOwner){ ball ->
            if(ball!=null){
                list.add(ball)
                setBowlerRecycler()
                ballBowled = Ball()
            }
        }

        binding.zeroRun.setOnClickListener {
            ballBowled.runScored = 0
        }

        binding.submit.setOnClickListener {
            viewModel.currentBall.postValue(ballBowled)
        }
        binding.oneRun.setOnClickListener {
            ballBowled.runScored = 1
        }
        binding.twoRun.setOnClickListener {
            ballBowled.runScored = 2
        }
        binding.reset.setOnClickListener {
            ballBowled = Ball()
        }

        binding.threeRun.setOnClickListener {
            ballBowled.runScored = 3
        }
        binding.fourRun.setOnClickListener {
            ballBowled.runScored = 4
        }
        binding.sixRun.setOnClickListener {
            ballBowled.runScored = 6
        }
        binding.moreRun.setOnClickListener {
            ballBowled.runScored = 5
        }

        binding.wideBall.setOnClickListener {
            ballBowled.isWideBall = true
        }
        binding.noBall.setOnClickListener {
            ballBowled.isNoBall = true
        }
        binding.runByByes.setOnClickListener {
            ballBowled.isScoreByByes = true
        }
        binding.out.setOnClickListener {
            ballBowled.isWicket = true
            ballBowled.wicketBy = Wicket.Bowled.name
        }
    }

    fun setBowlerRecycler(){
        binding.recyclerView.clear()
        binding.recyclerView.withModels {
            list.forEachIndexed { index, any ->
                layoutBall {
                    id(index)
                    ball(any as Ball)
                    clickListener { model, parentView, clickedView, position ->

                    }
                }
            }
        }
    }

}