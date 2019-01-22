package com.example.ribtest.rib.root.feed

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.LinearLayoutManager
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.example.ribtest.rib.root.feed.delegate.ListItemDelegate
import com.example.ribtest.rib.root.feed.enitity.ListItem
import com.example.ribtest.view.LIST_ITEM
import com.example.ribtest.view.template.delegateadapter.RibbonAdapter
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject
import kotlinx.android.synthetic.main.rib_feed.view.*

/**
 * Top level view for {@link FeedBuilder.FeedScope}.
 */
class FeedView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyle: Int = 0
) : ConstraintLayout(context, attrs, defStyle), FeedInteractor.FeedPresenter {

    override val clickedItem: Subject<ListItem> = PublishSubject.create()
    override val visibility: Subject<Int> = PublishSubject.create()

    override fun onFinishInflate() {
        super.onFinishInflate()
        rvFeed.layoutManager = LinearLayoutManager(context).apply {
            orientation = LinearLayoutManager.VERTICAL
        }
        rvFeed.adapter = RibbonAdapter(ListItemDelegate(clickedItem::onNext) to LIST_ITEM).apply {
            refresh(ListItem("string 1"), ListItem("string 2"), ListItem("string 3"))
        }
    }

    override fun onVisibilityChanged(changedView: View?, visibility: Int) {
        super.onVisibilityChanged(changedView, visibility)
        Log.d("test", "FeedView visibilityChanged $visibility")
        this.visibility.onNext(visibility)
    }


    override fun showCounter(count: Long) {
        textView.text = count.toString()
    }
}
