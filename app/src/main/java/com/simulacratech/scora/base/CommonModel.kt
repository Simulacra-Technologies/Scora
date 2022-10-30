package com.simulacratech.scora.base

data class Waiting(var isWaiting:Boolean, val waitingText:String? = null)

data class ConfigToolbar(var title:String = "", var navigationIcon:Int? = null)

data class Game(var title:String = "")

data class Team(
    var teamId:Int,
    var teamName:String,
    var captainName:String,
    var teamIcon:String,
)
data class Ball(
    var runScored:Int = 0,
    var isNoBall:Boolean = false,
    var isWideBall:Boolean = false,
    var isScoreByByes:Boolean = false,
    var isWicket:Boolean = false,
    var wicketBy:String = "",
){
    fun getDisplayTitle():String{
        if(isNoBall){
            return "$runScored NB"
        }else if(isWideBall){
            return "$runScored Wd"
        }else if(isScoreByByes){
            return "$runScored B"
        }else if(isWicket && wicketBy.equals(Wicket.RunOut)){
            return "$runScored NB"
        }else if(isWicket){
            return "W"
        }else{
            return "$runScored"
        }
    }
}

enum class Wicket{
    Bowled,
    Caught,
    LBW,
    RunOut,
    STUMPED,
    Retired,
    HitTheBallTwice,
    HitWicket,
    ObstructingTheField,
    TimedOut
}