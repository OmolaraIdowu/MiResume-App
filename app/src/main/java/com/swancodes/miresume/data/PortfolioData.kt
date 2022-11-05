package com.swancodes.miresume.data

import com.swancodes.miresume.R
import com.swancodes.miresume.model.Portfolio

class PortfolioData {
    fun getPortfolioData(): ArrayList<Portfolio> {
        return arrayListOf(
            Portfolio(
                R.string.my_plant_app,
                R.drawable.image_2
            ),
            Portfolio(
                R.string.e_commerce,
                R.drawable.image_3
            ),
            Portfolio(
                R.string.ibook,
                R.drawable.image_4
            )
        )
    }
}