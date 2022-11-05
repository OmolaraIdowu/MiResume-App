package com.swancodes.miresume.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Experience(
    @StringRes
    val stringResourceId: Int,
    val stringResourceId2: Int,
    val stringResourceId3: Int,
    @DrawableRes
    val imageResourceId: Int
)
