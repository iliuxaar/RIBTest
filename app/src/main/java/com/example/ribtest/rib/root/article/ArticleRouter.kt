package com.example.ribtest.rib.root.article

import android.view.ViewGroup
import com.example.ribtest.navigation.BaseRouter
import com.example.ribtest.navigation.States

/**
 * Adds and removes children of {@link ArticleBuilder.ArticleScope}.
 */
class ArticleRouter(
    view: ArticleView,
    interactor: ArticleInteractor,
    component: ArticleBuilder.Component,
    parentView: ViewGroup) : BaseRouter<ArticleView, ArticleInteractor, ArticleBuilder.Component, States>(view, interactor, component, parentView){
}
