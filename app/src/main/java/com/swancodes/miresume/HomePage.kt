package com.swancodes.miresume

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.swancodes.miresume.databinding.ActivityHomePageBinding
import com.swancodes.miresume.util.navigate


class HomePage : AppCompatActivity() {
    private lateinit var binding: ActivityHomePageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mailText.setOnClickListener {
            val bottomSheetDialog = BottomSheetDialog(
                this@HomePage, R.style.BottomSheetDailogTheme
            )
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.bottom_sheet_layout,
                findViewById<ConstraintLayout>(R.id.bottomSheet)
            )
            bottomSheetView.findViewById<View>(R.id.gitHubImage).setOnClickListener {
                gotoUrl("https://github.com/OmolaraIdowu")
            }
            bottomSheetView.findViewById<View>(R.id.linkedInImage).setOnClickListener {
                gotoUrl("https://www.linkedin.com/in/omolara-idowu-0273661b4")
            }
            bottomSheetView.findViewById<View>(R.id.twitterImage).setOnClickListener {
                gotoUrl("https://mobile.twitter.com/Lara_Idowuu")
            }
            bottomSheetView.findViewById<View>(R.id.sendButton).setOnClickListener {
                Toast.makeText(this@HomePage, "Sending...", Toast.LENGTH_SHORT).show()
                bottomSheetDialog.dismiss()
            }
            bottomSheetDialog.setContentView(bottomSheetView)
            bottomSheetDialog.show()
        }

        binding.aboutMe.setOnClickListener {
            navigate(MainActivity::class.java)
        }

        binding.portfolioButton.setOnClickListener {
            navigate(PortfolioPage::class.java)
        }
    }

    private fun gotoUrl(link: String) {
        val uri = Uri.parse(link)
        startActivity(Intent(Intent.ACTION_VIEW, uri))
    }
    override fun onBackPressed() {
    }
}