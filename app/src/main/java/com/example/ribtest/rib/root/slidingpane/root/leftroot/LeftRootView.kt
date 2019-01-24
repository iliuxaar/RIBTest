package com.example.ribtest.rib.root.slidingpane.root.leftroot

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet

/**
 * Top level view for {@link LeftRootBuilder.LeftRootScope}.
 */
class LeftRootView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) : ConstraintLayout(context, attrs, defStyle), LeftRootInteractor.LeftRootPresenter
