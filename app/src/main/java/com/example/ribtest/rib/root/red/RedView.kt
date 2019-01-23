package com.example.ribtest.rib.root.red

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet

/**
 * Top level view for {@link RedBuilder.RedScope}.
 */
class RedView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0) : ConstraintLayout(context, attrs, defStyle), RedInteractor.RedPresenter
