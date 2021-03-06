package com.example.ribtest.rib.root

import com.example.ribtest.navigation.States
import com.example.ribtest.navigation.StatesStack
import com.example.ribtest.rib.root.article.ArticleBuilder
import com.example.ribtest.rib.root.feed.FeedBuilder
import com.example.ribtest.rib.root.feed.enitity.ListItem
import com.example.ribtest.rib.root.slidingpane.SlidingPaneBuilder
import com.example.ribtest.rib.root.slidingpane.SlidingPaneRouter
import com.uber.rib.core.ModernRouterNavigator
import com.uber.rib.core.ViewRouter
import kotlin.random.Random

/**
 * Adds and removes children of {@link RootBuilder.RootScope}.
 */
class RootRouter(
    view: RootView,
    interactor: RootInteractor,
    component: RootBuilder.Component,
    private val feedBuilder: FeedBuilder,
    private val articleBuilder: ArticleBuilder,
    private val slidingPaneBuilder: SlidingPaneBuilder
) : ViewRouter<RootView, RootInteractor, RootBuilder.Component>(view, interactor, component) {

    private val routerNavigator: ModernRouterNavigator<States> = ModernRouterNavigator(this)

    private val random: Random = Random(0)

    public val states: StatesStack = StatesStack()

    fun attachFeed() = feedBuilder.build(view).let { router ->
        routerNavigator.pushRetainedState(States.FEED, router, router)
        states.addState(States.FEED)
    }

    fun attachArticle(listItem: ListItem) {
        if(random.nextInt(1, 10) % 2 == 0){
            articleBuilder.build(view, listItem).let { router ->
                routerNavigator.pushRetainedState(States.ARTICLE, router, router)
                states.addState(States.ARTICLE)
            }
        } else attachArticleWithRed(listItem)
    }

    fun attachArticleWithRed(listItem: ListItem) {
        articleBuilder.build(view, listItem).let { router ->
            routerNavigator.pushRetainedState(States.ARTICLE_WITH_RED, router, router)
            states.addState(States.ARTICLE_WITH_RED)
        }
    }

    fun attachSlidingPane(){
        slidingPaneBuilder.build(view).let { router ->
            routerNavigator.pushRetainedState(States.SLIDING_PANE, router, router)
            states.addState(States.SLIDING_PANE)
        }
    }

    fun detachFeed() = {
        routerNavigator.popState()
    }

    fun detachArticle() = {
        routerNavigator.popState()
    }

    fun onBackClick(): Int{
        if(routerNavigator.peekState() == States.SLIDING_PANE) {
            val isEmpty = (routerNavigator.peekRouter() as SlidingPaneRouter).onBackClick()
            states.removeState(States.SLIDING_PANE)
            if(isEmpty) routerNavigator.popState()
            return 1
        }
        states.removeState(routerNavigator.peekState()!!)
        routerNavigator.popState()
        return if(routerNavigator.size() == 0) 0 else 1
    }

}
