package com.example.ribtest.rib.root.slidingpane.root.rightroot

import android.view.View

import com.uber.rib.core.ViewRouter

/**
 * Adds and removes children of {@link RightRootBuilder.RightRootScope}.
 *
 * TODO describe the possible child configurations of this scope.
 */
class RightRootRouter(
    view: RightRootView,
    interactor: RightRootInteractor,
    component: RightRootBuilder.Component) : ViewRouter<RightRootView, RightRootInteractor, RightRootBuilder.Component>(view, interactor, component)
