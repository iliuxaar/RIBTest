package com.example.ribtest.rib.root.slidingpane.root.rightroot

import com.example.ribtest.navigation.BaseRouter
import com.example.ribtest.navigation.States
import com.example.ribtest.rib.root.slidingpane.right.first.FirstRightBuilder
import com.example.ribtest.rib.root.slidingpane.right.second.SecondRightBuilder
import com.uber.rib.core.ModernRouterNavigator

/**
 * Adds and removes children of {@link RightRootBuilder.RightRootScope}.
 *
 * TODO describe the possible child configurations of this scope.
 */
class RightRootRouter(
        view: RightRootView,
        interactor: RightRootInteractor,
        component: RightRootBuilder.Component,
        private val firstRightBuilder: FirstRightBuilder,
        private val secondRightBuilder: SecondRightBuilder) : BaseRouter<RightRootView, RightRootInteractor, RightRootBuilder.Component, States>(view, interactor, component, view) {

    //тут можно ещё создать без presenter и view. Только тогда нужно будет передать через ParentComponent SlidingPaneView и выбрать ответвление, мне кажется так удобней

    fun attachFirstRight(navigator: ModernRouterNavigator<States>) = firstRightBuilder.build(view).let { router -> navigator.pushRetainedState(States.FIRST_RIGHT, router, router) }

    fun attachSecondRight(navigator: ModernRouterNavigator<States>) = secondRightBuilder.build(view).let { router -> navigator.pushRetainedState(States.SECOND_RIGHT, router, router) }


}
