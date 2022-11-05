package com.swancodes.miresume.data

import com.swancodes.miresume.R
import com.swancodes.miresume.model.Education

class EducationData {
    fun getEducationData(): ArrayList<Education> {
        return arrayListOf(
            Education(
                R.string.the_polytechnic_ibadan,
                R.string._2019_2022,
                R.string.accountancy_national_diploma,
                R.drawable.ic_award
            ),
            Education(
                R.string.mate_comprehensive_high_school,
                R.string.class_of_2015,
                R.string.ssce_graduate,
                R.drawable.ic_award
            ),
            Education(
                R.string.ollyrock_international_school,
                R.string._2003_2009,
                R.string.first_school_leaving_certificate,
                R.drawable.ic_award
            )
        )
    }
}