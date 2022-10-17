package com.simulacratech.scora.base

data class Waiting(var isWaiting:Boolean, val waitingText:String? = null)

data class ConfigToolbar(var title:String = "", var navigationIcon:Int? = null)
