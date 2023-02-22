package com.team.core.common

sealed class FireType {
    data class AuthFire(val someData: Int) : FireType()
    class SingleFire(val ss: Int): FireType()
}