package com.example.ribtest.rib.root.slidingpane.root.leftroot

import com.example.ribtest.navigation.BaseRouter
import com.example.ribtest.navigation.States
import com.example.ribtest.rib.root.slidingpane.left.first.FirstLeftBuilder
import com.example.ribtest.rib.root.slidingpane.left.second.SecondLeftBuilder
import com.uber.rib.core.ModernRouterNavigator

/**
 * Adds and removes children of {@link LeftRootBuilder.LeftRootScope}.
 *
 * TODO describe the possible child configurations of this scope.
 */
class LeftRootRouter(
        view: LeftRootView,
        interactor: LeftRootInteractor,
        component: LeftRootBuilder.Component,
        private val firstLeftBuilder: FirstLeftBuilder,
        private val secondLeftBuilder: SecondLeftBuilder) : BaseRouter<LeftRootView, LeftRootInteractor, LeftRootBuilder.Component, States>(view, interactor, component, view) {

    //тут можно ещё создать без presenter и view. Только тогда нужно будет передать через ParentComponent SlidingPaneView и выбрать ответвление, мне кажется так удобней

    fun attachFirstLeft(navigator: ModernRouterNavigator<States>) = firstLeftBuilder.build(view).let { router -> navigator.pushRetainedState(States.FIRST_LEFT, router, router) }

    fun attachSecondLeft(navigator: ModernRouterNavigator<States>) = secondLeftBuilder.build(view).let { router -> navigator.pushRetainedState(States.SECOND_LEFT, router, router) }


}
