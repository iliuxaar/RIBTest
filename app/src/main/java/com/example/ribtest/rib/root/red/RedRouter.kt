package com.example.ribtest.rib.root.red

import android.view.View

import com.uber.rib.core.ViewRouter

/**
 * Adds and removes children of {@link RedBuilder.RedScope}.
 *
 * TODO describe the possible child configurations of this scope.
 */
class RedRouter(
    view: RedView,
    interactor: RedInteractor,
    component: RedBuilder.Component) : ViewRouter<RedView, RedInteractor, RedBuilder.Component>(view, interactor, component)
