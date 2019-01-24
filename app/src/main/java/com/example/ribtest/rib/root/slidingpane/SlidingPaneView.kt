package com.example.ribtest.rib.root.slidingpane

import android.content.Context
import android.graphics.Color
import android.support.v4.content.ContextCompat
import android.support.v4.widget.SlidingPaneLayout
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import com.example.ribtest.R
import kotlinx.android.synthetic.main.rib_sliding_pane.view.*

/**
 * Top level view for {@link SlidingPaneBuilder.SlidingPaneScope}.
 */
class SlidingPaneView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) : FrameLayout(context, attrs, defStyle),
        SlidingPaneInteractor.SlidingPanePresenter {


    private var mIsRightPaneOpened: Boolean = false

    override fun onFinishInflate() {
        super.onFinishInflate()
        val margin = 70f
        sliding_pane_layout.setShadowDrawableRight(ContextCompat.getDrawable(context, R.drawable.shape_gradient_right_shadow))
        sliding_pane_layout.setSliderFadeColor(Color.TRANSPARENT)
        post {
            right_container.translationX = right_container.getWidth() - margin
            sliding_pane_layout.closePane()
        }
        sliding_pane_layout.setPanelSlideListener(object : SlidingPaneLayout.PanelSlideListener {
            override fun onPanelSlide(panel: View, slideOffset: Float) {
                val moveFactor = (right_container.width - margin) * (1 - slideOffset)
                right_container.translationX = moveFactor
            }

            override fun onPanelOpened(panel: View) {
                mIsRightPaneOpened = true
            }

            override fun onPanelClosed(panel: View) {
                mIsRightPaneOpened = false
            }
        })
    }

    public fun isRightPaneOpened() = mIsRightPaneOpened

}
