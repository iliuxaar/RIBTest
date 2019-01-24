package com.example.ribtest.rib.root.slidingpane.root.rightroot

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet

/**
 * Top level view for {@link RightRootBuilder.RightRootScope}.
 */
class RightRootView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) : ConstraintLayout(context, attrs, defStyle), RightRootInteractor.RightRootPresenter
