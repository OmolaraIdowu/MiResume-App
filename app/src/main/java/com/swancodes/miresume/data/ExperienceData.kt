package com.swancodes.miresume.data

import com.swancodes.miresume.R
import com.swancodes.miresume.model.Experience

class ExperienceData {
    fun getExperienceData(): ArrayList<Experience> {
        return arrayListOf(
            Experience(
                R.string.mobile_app_developer,
                R.string._2021_now,
                R.string.freelancer,
                R.drawable.ic_experience
            ),
            Experience(
                R.string.computer_operator,
                R.string._2020_2021,
                R.string.rinse_creative_lab,
                R.drawable.ic_experience
            ),
            Experience(
                R.string.baker,
                R.string._2016_2019,
                R.string.crown_cakes,
                R.drawable.ic_experience
            )
        )
    }
}