package com.d33t.intervalbeeper

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            val repeats =  repeatsCountEdit.text.toString().toInt()
            val firstInterval = firstIntervalEdit.text.toString().toInt()
            val secondInterval = secondIntervalEdit.text.toString().toInt()

            val handler = Handler()
            val delay = 1000L

            var count = 1
            var repeatsCount = 0
            var currentIntervalNum = 0
            handler.postDelayed(object : Runnable {
                override fun run() {
                    if (currentIntervalNum == 0) {
                        if (count < firstInterval) {
                            BeepHelper().beep(100)
                        } else {
                            BeepHelper().finalBeep(200)
                            count = 0
                            currentIntervalNum = 1
                        }
                    } else {
                        if (count < secondInterval) {
                            BeepHelper().beep(100)
                        } else {
                            BeepHelper().finalBeep(200)
                            count = 0
                            currentIntervalNum = 0
                            repeatsCount++
                        }
                    }

                    count++
                    if (repeatsCount < repeats) {
                        handler.postDelayed(this, 900)
                    }
                }
            }, delay)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
