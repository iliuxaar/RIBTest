package com.example.ribtest.rib.root.slidingpane

import android.view.ViewGroup
import com.example.ribtest.navigation.BaseRouter
import com.example.ribtest.navigation.States
import com.example.ribtest.rib.root.slidingpane.left.first.FirstLeftBuilder
import com.example.ribtest.rib.root.slidingpane.left.second.SecondLeftBuilder
import com.example.ribtest.rib.root.slidingpane.right.first.FirstRightBuilder
import com.example.ribtest.rib.root.slidingpane.right.second.SecondRightBuilder
import com.uber.rib.core.ModernRouterNavigator

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
    private val firstLeftBuilder: FirstLeftBuilder,
    private val secondLeftBuilder: SecondLeftBuilder,
    private val firstRightBuilder: FirstRightBuilder,
    private val secondRightBuilder: SecondRightBuilder
) : BaseRouter<SlidingPaneView, SlidingPaneInteractor, SlidingPaneBuilder.Component, States>(view, interactor, component, parentView){

    private val leftNavigator: ModernRouterNavigator<States> = ModernRouterNavigator(this)
    private val rightNavigator: ModernRouterNavigator<States> = ModernRouterNavigator(this)

    fun attachFirstLeft() = firstLeftBuilder.build(view).let { router -> leftNavigator.pushRetainedState(States.FIRST_LEFT, router, router) }

    fun attachFirstRight() = firstRightBuilder.build(view).let { router -> rightNavigator.pushRetainedState(States.FIRST_RIGHT, router, router) }

    fun attachSecondLeft() = secondLeftBuilder.build(view).let { router -> leftNavigator.pushRetainedState(States.SECOND_LEFT, router, router) }

    fun attachSecondRight() = secondRightBuilder.build(view).let { router -> rightNavigator.pushRetainedState(States.SECOND_RIGHT, router, router) }

}
