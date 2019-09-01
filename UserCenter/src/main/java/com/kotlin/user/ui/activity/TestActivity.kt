package com.kotlin.user.ui.activity

import android.os.Bundle
import android.app.Activity

import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

@Suppress("ImplicitThis")
class TestActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_test)
        verticalLayout {
            padding = 16
            editText {
                hint = "Name"
                textSize = 24f
            }
            editText {
                hint = "PWD"
                textSize = 24f
            }
            button {
                text = "Test"
                onClick {
                    toast("${intent.getIntExtra("id",-1)}")
                }
            }

        }

    }

}
