package com.example.ribtest.rib.root.slidingpane.left.second

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet

/**
 * Top level view for {@link SecondLeftBuilder.SecondLeftScope}.
 */
class SecondLeftView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) : ConstraintLayout(context, attrs, defStyle), SecondLeftInteractor.SecondLeftPresenter
