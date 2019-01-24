package com.example.ribtest.rib.root.slidingpane.root.leftroot

import android.view.View

import com.uber.rib.core.ViewRouter

/**
 * Adds and removes children of {@link LeftRootBuilder.LeftRootScope}.
 *
 * TODO describe the possible child configurations of this scope.
 */
class LeftRootRouter(
    view: LeftRootView,
    interactor: LeftRootInteractor,
    component: LeftRootBuilder.Component) : ViewRouter<LeftRootView, LeftRootInteractor, LeftRootBuilder.Component>(view, interactor, component)
