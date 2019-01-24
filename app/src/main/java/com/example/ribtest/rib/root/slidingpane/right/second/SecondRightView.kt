package com.example.ribtest.rib.root.slidingpane.right.second

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet

/**
 * Top level view for {@link SecondRightBuilder.SecondRightScope}.
 */
class SecondRightView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) : ConstraintLayout(context, attrs, defStyle), SecondRightInteractor.SecondRightPresenter
