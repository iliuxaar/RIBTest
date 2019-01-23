package com.example.ribtest.rib.root.article

import android.view.ViewGroup
import com.example.ribtest.navigation.BaseRouter
import com.example.ribtest.navigation.States
import com.example.ribtest.rib.root.red.RedBuilder
import com.example.ribtest.rib.root.red.RedRouter
import com.uber.rib.core.Interactor
import com.uber.rib.core.InteractorBaseComponent

/**
 * Adds and removes children of {@link ArticleBuilder.ArticleScope}.
 */
class ArticleRouter(
    view: ArticleView,
    interactor: ArticleInteractor,
    component: ArticleBuilder.Component,
    val redBuilder: RedBuilder,
    parentView: ViewGroup) : BaseRouter<ArticleView, ArticleInteractor, ArticleBuilder.Component, States>(view, interactor, component, parentView){

    var redRouter: RedRouter? = null


    fun attachRed() = redBuilder.build(view).let { router ->
        attachChild(router)
        view.addView(router.view)
        redRouter = router
    }

    fun detachRed() = redRouter?.let{ router ->
        detachChild(router)
        view.removeView(router.view)
        redRouter = null
    }

    override fun willAttachToHost(
        router: BaseRouter<*, out Interactor<*, *>, out InteractorBaseComponent<*>, *>?,
        previousState: States?,
        newState: States?,
        isPush: Boolean
    ) {
        super.willAttachToHost(router, previousState, newState, isPush)
        if(newState == States.ARTICLE_WITH_RED) (interactor as ArticleInteractor).openRedWindow()
    }
}
