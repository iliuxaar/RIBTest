package com.example.ribtest.rib.root.article

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import com.example.ribtest.rib.root.feed.enitity.ListItem
import com.jakewharton.rxbinding2.view.RxView
import io.reactivex.Observable
import kotlinx.android.synthetic.main.rib_article.view.*


/**
 * Top level view for {@link ArticleBuilder.ArticleScope}.
 */
class ArticleView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyle: Int = 0
) : ConstraintLayout(context, attrs, defStyle), ArticleInteractor.ArticlePresenter {

    override fun buttonClick(): Observable<Any>{
        return RxView.clicks(addRedViewButton)
    }


    override fun setListItem(listItem: ListItem) {
        tvTittle.text = listItem.text
    }

    override fun setButtonText(text: String) {
        addRedViewButton.text = text
    }

    override fun openPaneClick(): Observable<Any> {
        return RxView.clicks(addSlidePaneButton)
    }

}
