package com.example.ribtest.rib.root.article

import com.example.ribtest.rib.root.feed.enitity.ListItem
import com.uber.rib.core.Bundle
import com.uber.rib.core.Interactor
import com.uber.rib.core.RibInteractor
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Coordinates Business Logic for [ArticleScope].
 */
@RibInteractor
class ArticleInteractor : Interactor<ArticleInteractor.ArticlePresenter, ArticleRouter>() {

    @Inject lateinit var presenter: ArticlePresenter
    @Inject lateinit var listener: ArticleListener

    @Inject
    lateinit var listItem: ListItem

    override fun didBecomeActive(savedInstanceState: Bundle?) {
        super.didBecomeActive(savedInstanceState)
        presenter.setListItem(listItem)
        presenter.buttonClick().subscribe{listener.onButtonClick()}
    }


    /**
     * Presenter interface implemented by this RIB's view.
     */
    interface ArticlePresenter {
        fun buttonClick(): Observable<Any>
        fun setListItem(listItem: ListItem)
    }

    interface ArticleListener{
        fun onButtonClick()
    }
}
