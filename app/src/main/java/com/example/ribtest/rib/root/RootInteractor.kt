package com.example.ribtest.rib.root

import com.example.ribtest.navigation.States
import com.example.ribtest.navigation.StatesStack
import com.example.ribtest.rib.root.article.ArticleInteractor
import com.example.ribtest.rib.root.feed.FeedInteractor
import com.example.ribtest.rib.root.feed.enitity.ListItem
import com.uber.rib.core.Bundle
import com.uber.rib.core.Interactor
import com.uber.rib.core.RibInteractor
import javax.inject.Inject

/**
 * Coordinates Business Logic for [RootScope].
 */
@RibInteractor
class RootInteractor : Interactor<RootInteractor.RootPresenter, RootRouter>() {

    @Inject
    lateinit var presenter: RootPresenter

    override fun didBecomeActive(savedInstanceState: com.uber.rib.core.Bundle?) {
        super.didBecomeActive(savedInstanceState)
        if(savedInstanceState != null){
            val states = savedInstanceState.getParcelable("states") as StatesStack
            states.stack.forEach {state ->
                if(state == States.FEED) router.attachFeed()
                if(state == States.ARTICLE) router.attachArticle(ListItem("Saved State"))
                if(state == States.ARTICLE_WITH_RED) router.attachArticleWithRed(ListItem("Saved State"))
                if(state == States.SLIDING_PANE) router.attachSlidingPane()
            }
        } else router.attachFeed()
    }

    override fun handleBackPress(): Boolean {
        return true
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable("states",router.states)
    }

    /**
     * Presenter interface implemented by this RIB's view.
     */
    interface RootPresenter

    inner class FeedInteractorListener: FeedInteractor.Listener {
        override fun clickOnItem(listItem: ListItem) {
            //router.detachFeed()
            router.attachArticle(listItem)
        }
    }

    inner class ArticleInteractorListener: ArticleInteractor.SlidePaneListener {
        override fun openPaneLayout() {
            router.attachSlidingPane()
        }
    }

}
