package com.simulacratech.scora.ui.cricket.scoring

import androidx.lifecycle.MutableLiveData
import com.simulacratech.scora.base.Ball
import com.simulacratech.scora.base.BaseViewModel

class ScoringViewModel : BaseViewModel() {
    var currentBall = MutableLiveData<Ball>(null)
}