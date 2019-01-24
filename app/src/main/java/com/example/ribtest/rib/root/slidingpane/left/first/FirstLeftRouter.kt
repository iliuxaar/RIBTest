package com.example.ribtest.rib.root.slidingpane.left.first

import android.view.ViewGroup
import com.example.ribtest.navigation.BaseRouter
import com.example.ribtest.navigation.States

/**
 * Adds and removes children of {@link FirstLeftBuilder.FirstLeftScope}.
 *
 * TODO describe the possible child configurations of this scope.
 */
class FirstLeftRouter(
        view: FirstLeftView,
        interactor: FirstLeftInteractor,
        component: FirstLeftBuilder.Component,
        parentView: ViewGroup) : BaseRouter<FirstLeftView, FirstLeftInteractor, FirstLeftBuilder.Component, States>(view, interactor, component, parentView)
