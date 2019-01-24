package com.example.ribtest.rib.root.slidingpane.right.first

import android.view.ViewGroup
import com.example.ribtest.navigation.BaseRouter
import com.example.ribtest.navigation.States

/**
 * Adds and removes children of {@link FirstRightBuilder.FirstRightScope}.
 *
 * TODO describe the possible child configurations of this scope.
 */
class FirstRightRouter(
    view: FirstRightView,
    interactor: FirstRightInteractor,
    component: FirstRightBuilder.Component,
    parentView: ViewGroup) : BaseRouter<FirstRightView, FirstRightInteractor, FirstRightBuilder.Component, States>(view, interactor, component, parentView)
