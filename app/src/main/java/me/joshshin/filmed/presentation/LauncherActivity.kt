package me.joshshin.filmed.presentation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by Josh Shin on 5/5/18
 */

class LauncherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (FilmedIntroActivity.hasSeenScreen) {
            this.startActivity(MoviesActivity.getIntent(this))
        } else {
            this.startActivity(FilmedIntroActivity.getIntent(this))
        }
    }
}