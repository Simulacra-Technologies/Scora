package com.simulacratech.scora

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.simulacratech.scora.base.BaseViewModel
import com.simulacratech.scora.base.ConfigToolbar
import com.simulacratech.scora.base.Waiting
import com.simulacratech.scora.core.DispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel@Inject constructor(
    private val dispatchers: DispatcherProvider
) : BaseViewModel() {

    var title = MutableLiveData<String>()

    var previousConfigToolbar: ConfigToolbar = ConfigToolbar()
    var currentConfigToolbar: ConfigToolbar = ConfigToolbar()

    private val toolbarTitleEventChannel = Channel<ConfigToolbar>()

    val toolbarTitleEventFlow = toolbarTitleEventChannel.receiveAsFlow()

    fun toolbarTitle(configToolbar: ConfigToolbar) = viewModelScope.launch {
        toolbarTitleEventChannel.send(configToolbar)
        /*if(configToolbar.title.isEmpty()){
            logoVisibility.postValue(View.VISIBLE)
        }else{
            logoVisibility.postValue(View.GONE)
        }
        */
        title.postValue(configToolbar.title)
        currentConfigToolbar = configToolbar
    }

    var waiting: MutableLiveData<Waiting> = MutableLiveData(Waiting(false))

    var bottomNavHostVisibility = MutableLiveData(View.GONE)

    var bottomNavVisibility = MutableLiveData(View.GONE)

    var destinationLabel: CharSequence? = ""

    var menuNavHostVisibility = MutableLiveData(View.VISIBLE)

    private val changeNavGraphEventChannel = Channel<Int>()

    val changeNavGraphEventFlow = changeNavGraphEventChannel.receiveAsFlow()

    fun changeNavGraph(navGraph:Int) = viewModelScope.launch {
        changeNavGraphEventChannel.send(navGraph)
    }

}