package com.swancodes.miresume

import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.swancodes.miresume.databinding.ActivityMainBinding
import com.swancodes.miresume.fragments.AboutMeFragment
import com.swancodes.miresume.fragments.EducationFragment
import com.swancodes.miresume.fragments.ExperienceFragment
import com.swancodes.miresume.util.navigate
import java.util.*

private const val NUM_PAGES = 3

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var mImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        loadLocale()
        setContentView(binding.root)
        mImageView = binding.settingsText

        binding.apply {
            val pagerAdapter = ScreenSlidePagerAdapter(
                this@MainActivity,
                listOf(AboutMeFragment(), EducationFragment(), ExperienceFragment())
            )
            pager.adapter = pagerAdapter
            pager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {

                    if (position == 0) {
                        aboutMeHeading.setBackgroundResource(R.drawable.background_3)
                        educationHeading.setBackgroundResource(R.drawable.background)
                        experienceHeading.setBackgroundResource(R.drawable.background)
                        backArrow.setOnClickListener { navigate(HomePage::class.java) }
                    }

                    if (position == 1) {
                        aboutMeHeading.setBackgroundResource(R.drawable.background)
                        educationHeading.setBackgroundResource(R.drawable.background_2)
                        experienceHeading.setBackgroundResource(R.drawable.background)
                    }

                    if (position == 2) {
                        aboutMeHeading.setBackgroundResource(R.drawable.background)
                        educationHeading.setBackgroundResource(R.drawable.background)
                        experienceHeading.setBackgroundResource(R.drawable.background_3)
                    }
                }
            })
            settingsText.setOnClickListener {
                showLanguage()
            }
            aboutMeHeading
        }
    }

    private fun showLanguage() {
        val listLang = arrayOf("English", "German", "Spanish")
        val mBuilder = AlertDialog.Builder(this@MainActivity)
        mBuilder.setTitle("Choose Language")
        mBuilder.setSingleChoiceItems(listLang, -1) { dialog, which ->
            if (which == 0) {
                setLocale("en")
                recreate()
            } else if (which == 1) {
                setLocale("de")
                recreate()
            } else if (which == 2) {
                setLocale("es")
            }
            dialog.dismiss()
        }
        val mDialog = mBuilder.create()
        mDialog.show()
    }

    private fun setLocale(lang: String) {
        val locale = Locale(lang)
        Locale.setDefault(locale)
        val config = Configuration()

        config.locale = locale
        baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)

        val editor = getSharedPreferences("Settings", Context.MODE_PRIVATE).edit()
        editor.putString("My Language", lang)
        editor.apply()
    }

    private fun loadLocale() {
        val sharedPreferences = getSharedPreferences("Settings", Activity.MODE_PRIVATE)
        val language = sharedPreferences.getString("My Language", "")
        if (language != null) {
            setLocale(language)
        }
    }

    private inner class ScreenSlidePagerAdapter(
        fa: FragmentActivity,
        private val screens: List<Fragment>,
    ) :
        FragmentStateAdapter(fa) {

        override fun getItemCount(): Int = NUM_PAGES

        override fun createFragment(position: Int): Fragment = screens[position]
    }

    override fun onBackPressed() {
        if (binding.pager.currentItem == 0) {
            super.onBackPressed()
        } else {
            binding.pager.currentItem = binding.pager.currentItem - 1
        }
    }

}
