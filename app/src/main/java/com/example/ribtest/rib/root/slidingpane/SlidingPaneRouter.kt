package com.example.ribtest.rib.root.slidingpane

import android.view.ViewGroup
import com.example.ribtest.navigation.BaseRouter
import com.example.ribtest.navigation.States
import com.example.ribtest.rib.root.slidingpane.root.leftroot.LeftRootBuilder
import com.example.ribtest.rib.root.slidingpane.root.leftroot.LeftRootRouter
import com.example.ribtest.rib.root.slidingpane.root.rightroot.RightRootBuilder
import com.example.ribtest.rib.root.slidingpane.root.rightroot.RightRootRouter
import com.uber.rib.core.ModernRouterNavigator
import kotlinx.android.synthetic.main.rib_sliding_pane.view.*

/**
 * Adds and removes children of {@link SlidingPaneBuilder.SlidingPaneScope}.
 *
 * TODO describe the possible child configurations of this scope.
 */
class SlidingPaneRouter(
        view: SlidingPaneView,
        interactor: SlidingPaneInteractor,
        component: SlidingPaneBuilder.Component,
        parentView: ViewGroup,
        private val leftRootBuilder: LeftRootBuilder,
        private val rightRootBuilder: RightRootBuilder
) : BaseRouter<SlidingPaneView, SlidingPaneInteractor, SlidingPaneBuilder.Component, States>(view, interactor, component, parentView) {

    private val leftNavigator: ModernRouterNavigator<States> = ModernRouterNavigator(this)
    private val rightNavigator: ModernRouterNavigator<States> = ModernRouterNavigator(this)

    private var leftRootRouter: LeftRootRouter? = null
    private var rightRootRouter: RightRootRouter? = null

    fun attachLeftRoot() = leftRootBuilder.build(view.left_container, leftNavigator).let { router ->
        attachChild(router)
        view.left_container.addView(router.view)
        leftRootRouter = router
    }

    fun attachRightRoot() = rightRootBuilder.build(view.right_container, rightNavigator).let { router ->
        attachChild(router)
        view.right_container.addView(router.view)
        rightRootRouter = router
    }

    private fun popView(navigator: ModernRouterNavigator<States>): Boolean {
        return if (navigator.size() == 1) true
        else {
            navigator.popState()
            false
        }
    }

    fun onBackClick(): Boolean {
        return if (view.isRightPaneOpened()) popView(rightNavigator)
        else popView(leftNavigator)
    }

}
