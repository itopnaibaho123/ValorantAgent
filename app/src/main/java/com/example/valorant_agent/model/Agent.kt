package com.example.valorant_agent.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Agent(
    val name: String,
    val description: String,
    val iconUrl: String,
    val role: String
): Parcelable
