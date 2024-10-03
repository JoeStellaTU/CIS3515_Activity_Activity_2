package edu.temple.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class DisplayActivity : AppCompatActivity() {

    // TODO Step 1: Launch TextSizeActivity when button clicked to allow selection of text size value

    // TODO Step 3: Use returned value for lyricsDisplayTextView text size

    private lateinit var lyricsDisplayTextView: TextView
    private lateinit var textSizeSelectorButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        textSizeSelectorButton.setOnClickListener{
            val intent = Intent(this, TextSizeActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE_TEXT_SIZE)
        }




        lyricsDisplayTextView = findViewById(R.id.lyricsDisplayTextView)
        textSizeSelectorButton = findViewById(R.id.textSizeSelectorButton)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_CODE_TEXT_SIZE && resultCode == Activity.RESULT_OK){
            val textSize = data?.getFloatExtra("selectedTextSize", 16f) ?: 16f
            lyricsDisplayTextView.textSize = textSize
        }
    }

    companion object {
        const val REQUEST_CODE_TEXT_SIZE = 1
    }
}