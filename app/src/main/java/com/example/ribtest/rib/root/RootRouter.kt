package com.example.ribtest.rib.root

import com.example.ribtest.navigation.States
import com.example.ribtest.rib.root.article.ArticleBuilder
import com.example.ribtest.rib.root.feed.FeedBuilder
import com.example.ribtest.rib.root.feed.enitity.ListItem
import com.example.ribtest.rib.root.red.RedBuilder
import com.example.ribtest.rib.root.red.RedRouter
import com.uber.rib.core.ModernRouterNavigator
import com.uber.rib.core.ViewRouter

/**
 * Adds and removes children of {@link RootBuilder.RootScope}.
 */
class RootRouter(
    view: RootView,
    interactor: RootInteractor,
    component: RootBuilder.Component,
    private val feedBuilder: FeedBuilder,
    private val articleBuilder: ArticleBuilder,
    private val redBuilder: RedBuilder
) : ViewRouter<RootView, RootInteractor, RootBuilder.Component>(view, interactor, component) {

    private val routerNavigator: ModernRouterNavigator<States> = ModernRouterNavigator(this)

    var redRouter: RedRouter? = null

    fun attachFeed() = feedBuilder.build(view).let { router ->
        routerNavigator.pushRetainedState(States.FEED, router, router)
    }

    fun attachArticle(listItem: ListItem) = articleBuilder.build(view, listItem).let { router ->
        routerNavigator.pushRetainedState(States.ARTICLE, router, router)
    }

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

    fun detachFeed() = {
        routerNavigator.popState()
    }

    fun detachArticle() = {
        routerNavigator.popState()
    }

    fun onBackClick(): Int{
        routerNavigator.popState()
        return if(routerNavigator.size() == 0) 0 else 1
    }

}
