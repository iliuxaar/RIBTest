package com.example.ribtest.rib.root.slidingpane.right.first

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import com.jakewharton.rxbinding2.view.RxView
import io.reactivex.Observable
import kotlinx.android.synthetic.main.rib_first_right.view.*

/**
 * Top level view for {@link FirstRightBuilder.FirstRightScope}.
 */
class FirstRightView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) : ConstraintLayout(context, attrs, defStyle), FirstRightInteractor.FirstRightPresenter {

    override fun buttonClick(): Observable<Any> {
        return RxView.clicks(rightButton)
    }

}
