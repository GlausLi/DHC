package com.example.dhc.activity

import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.text.method.LinkMovementMethod
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.dhc.R


@Suppress("DEPRECATION")
class PersonalInfoActivity : AppCompatActivity() {

    private lateinit var link: TextView
    private lateinit var nextBtn: TextView
    private lateinit var editText: EditText
    private lateinit var maleBtn: TextView
    private lateinit var femaleBtn: TextView
    private lateinit var otherGenderBtn: TextView
    private lateinit var description: TextView

    private lateinit var genderFlag: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_info)

        link = findViewById(R.id.link)
        link.movementMethod = LinkMovementMethod.getInstance()
        link.text = Html.fromHtml(getString(R.string.intro_view_terms_of_service))

        nextBtn = findViewById(R.id.nextBtn)
        nextBtn.setOnClickListener{
            val intent = Intent(this, NotificationGuidanceActivity::class.java)
            startActivity(intent)
            finish()
        }

        editText = findViewById(R.id.editText)

        maleBtn = findViewById(R.id.maleBtn)
        maleBtn.setOnClickListener{
            genderFlag = "male"
            selectGender()
        }

        femaleBtn = findViewById(R.id.femaleBtn)
        femaleBtn.setOnClickListener{
            genderFlag = "female"
            selectGender()
        }

        otherGenderBtn = findViewById(R.id.otherGenderBtn)
        otherGenderBtn.setOnClickListener{
            genderFlag = "other"
            selectGender()
        }

        genderFlag = "male"
        selectGender()

        description = findViewById(R.id.description)
        description.text = getString(R.string.intro_nickname_description)
//            .replace("", "\u00A0")
    }

    fun selectGender() {
        when(genderFlag) {
            "male" -> {
                maleBtn.setTextColor(getColor(R.color.white))
                maleBtn.setBackgroundResource(R.drawable.bg_round8_brand7)
                femaleBtn.setTextColor(getColor(R.color.brand_9))
                femaleBtn.setBackgroundResource(R.drawable.bg_round8_transparent)
                otherGenderBtn.setTextColor(getColor(R.color.brand_9))
                otherGenderBtn.setBackgroundResource(R.drawable.bg_round8_transparent)
            }
            "female" -> {
                maleBtn.setTextColor(getColor(R.color.brand_9))
                maleBtn.setBackgroundResource(R.drawable.bg_round8_transparent)
                femaleBtn.setTextColor(getColor(R.color.white))
                femaleBtn.setBackgroundResource(R.drawable.bg_round8_brand7)
                otherGenderBtn.setTextColor(getColor(R.color.brand_9))
                otherGenderBtn.setBackgroundResource(R.drawable.bg_round8_transparent)
            }
            else -> {
                maleBtn.setTextColor(getColor(R.color.brand_9))
                maleBtn.setBackgroundResource(R.drawable.bg_round8_transparent)
                femaleBtn.setTextColor(getColor(R.color.brand_9))
                femaleBtn.setBackgroundResource(R.drawable.bg_round8_transparent)
                otherGenderBtn.setTextColor(getColor(R.color.white))
                otherGenderBtn.setBackgroundResource(R.drawable.bg_round8_brand7)
            }
        }
    }
}
