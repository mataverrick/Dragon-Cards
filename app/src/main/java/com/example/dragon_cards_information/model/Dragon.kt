package com.example.dragon_cards_information.model

import androidx.annotation.StringRes
import androidx.annotation.DrawableRes

data class Dragon(
    @StringRes val stringNameId: Int,
    @DrawableRes val imageId: Int
)
