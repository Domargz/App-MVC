package com.david.myweatherisit.model.dto

import kotlinx.serialization.Serializable

@Serializable
data class Condition(
    val icon: String
)