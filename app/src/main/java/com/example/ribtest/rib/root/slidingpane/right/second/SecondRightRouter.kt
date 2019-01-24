package com.example.ribtest.rib.root.slidingpane.right.second

import android.view.ViewGroup
import com.example.ribtest.navigation.BaseRouter
import com.example.ribtest.navigation.States

/**
 * Adds and removes children of {@link SecondRightBuilder.SecondRightScope}.
 *
 * TODO describe the possible child configurations of this scope.
 */
class SecondRightRouter(
    view: SecondRightView,
    interactor: SecondRightInteractor,
    component: SecondRightBuilder.Component,
    parentView: ViewGroup) : BaseRouter<SecondRightView, SecondRightInteractor, SecondRightBuilder.Component, States>(view, interactor, component, parentView)
