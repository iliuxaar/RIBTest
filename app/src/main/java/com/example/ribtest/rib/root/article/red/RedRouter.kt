package com.example.ribtest.rib.root.article.red

import android.view.ViewGroup
import com.example.ribtest.navigation.BaseRouter
import com.example.ribtest.navigation.States

/**
 * Adds and removes children of {@link RedBuilder.RedScope}.
 *
 * TODO describe the possible child configurations of this scope.
 */
class RedRouter(
        view: RedView,
        interactor: RedInteractor,
        component: RedBuilder.Component,
        parentView: ViewGroup) : BaseRouter<RedView, RedInteractor, RedBuilder.Component, States>(view, interactor, component, parentView)
