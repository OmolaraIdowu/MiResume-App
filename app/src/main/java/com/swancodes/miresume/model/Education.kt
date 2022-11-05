package com.swancodes.miresume.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Education(
    @StringRes
    val stringResourceId: Int,
    val stringResourceId2: Int,
    val stringResourceId3: Int,
    @DrawableRes
    val imageResourceId: Int
)

