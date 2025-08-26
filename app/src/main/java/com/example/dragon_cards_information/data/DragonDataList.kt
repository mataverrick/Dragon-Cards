package com.example.dragon_cards_information.data

import androidx.compose.ui.res.stringResource
import com.example.dragon_cards_information.model.Dragon
import com.example.dragon_cards_information.R

class DragonDataList {
    fun loadDragonList(): List<Dragon> {
        return listOf<Dragon>(
            Dragon(R.string.n_fury, R.drawable.n_fury)
        )
    }
}