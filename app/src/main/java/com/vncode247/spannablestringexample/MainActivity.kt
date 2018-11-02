package com.vncode247.spannablestringexample

import android.graphics.Color
import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.method.LinkMovementMethod
import android.text.style.*
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val styledString = SpannableString(
            "By continue, you agree to the Terms of Service and Privacy Policy"
        )

        val clickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                // We display a Toast. You could do anything you want here.
                Toast.makeText(this@MainActivity, "Clicked", Toast.LENGTH_SHORT).show()
            }
        }

        styledString.setSpan(clickableSpan, 30, 46, 0)

        // make text italic
        styledString.setSpan(StyleSpan(Typeface.ITALIC), 51, 65, 0)
        styledString.setSpan(StyleSpan(Typeface.BOLD), 51, 65, 0)

        // make text bold
        styledString.setSpan(StyleSpan(Typeface.BOLD), 30, 46, 0)

        // underline text
        styledString.setSpan(UnderlineSpan(), 30, 46, 0)

        // add strike through span
        styledString.setSpan(StrikethroughSpan(), 0, 11, 0)

        // change text color
        styledString.setSpan(ForegroundColorSpan(Color.RED), 30, 46, 0)

        // highlight text
        styledString.setSpan(BackgroundColorSpan(Color.WHITE), 30, 46, 0)

        // this step is mandated for the url and clickable styles.
        textView.movementMethod = LinkMovementMethod.getInstance()

        textView.text = styledString
    }
}
