package com.example.ribtest.rib.root.red

import android.content.Context
import android.util.AttributeSet
import android.view.View

/**
 * Top level view for {@link RedBuilder.RedScope}.
 */
class RedView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) : View(context, attrs, defStyle), RedInteractor.RedPresenter
