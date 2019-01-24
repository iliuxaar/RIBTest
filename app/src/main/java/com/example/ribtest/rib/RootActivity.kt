package com.example.ribtest.rib

import android.os.Bundle
import android.view.ViewGroup
import com.example.ribtest.rib.root.RootBuilder
import com.example.ribtest.rib.root.RootRouter
import com.uber.rib.core.RibActivity
import com.uber.rib.core.ViewRouter

class RootActivity : RibActivity() {

    override fun createRouter(parentViewGroup: ViewGroup): ViewRouter<*, *, *> =
            RootBuilder(object : RootBuilder.ParentComponent {}).build(parentViewGroup)

    override fun onBackPressed() {
        super.onBackPressed()
        val test: Int = (interactor.router as RootRouter).onBackClick()
        if(test == 0) finish()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
    }
}