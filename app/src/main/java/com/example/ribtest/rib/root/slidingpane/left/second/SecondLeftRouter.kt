package com.example.ribtest.rib.root.slidingpane.left.second

import android.view.ViewGroup
import com.example.ribtest.navigation.BaseRouter
import com.example.ribtest.navigation.States

/**
 * Adds and removes children of {@link SecondLeftBuilder.SecondLeftScope}.
 *
 * TODO describe the possible child configurations of this scope.
 */
class SecondLeftRouter(
    view: SecondLeftView,
    interactor: SecondLeftInteractor,
    component: SecondLeftBuilder.Component,
    parentView: ViewGroup) : BaseRouter<SecondLeftView, SecondLeftInteractor, SecondLeftBuilder.Component, States>(view, interactor, component, parentView)
