package com.example.ribtest.rib.root.feed

import android.view.ViewGroup
import com.example.ribtest.navigation.BaseRouter
import com.example.ribtest.navigation.States

/**
 * Adds and removes children of {@link FeedBuilder.FeedScope}.
 *
 * TODO describe the possible child configurations of this scope.
 */
class FeedRouter(
    view: FeedView,
    interactor: FeedInteractor,
    component: FeedBuilder.Component,
    parentView: ViewGroup) : BaseRouter<FeedView, FeedInteractor, FeedBuilder.Component, States>(view, interactor, component, parentView){

}
