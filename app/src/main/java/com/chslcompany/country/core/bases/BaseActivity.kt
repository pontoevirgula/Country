package com.chslcompany.country.core.bases

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

abstract class BaseActivity : AppCompatActivity() {

    protected  fun setupToolbar(toolbar: Toolbar, title: String, snowBackButton: Boolean = false){
        toolbar.title = title
        setSupportActionBar(toolbar)
        if (snowBackButton) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
    }
}