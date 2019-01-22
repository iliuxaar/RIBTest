package com.example.ribtest.rib.root.feed

import android.util.Log
import android.view.View.VISIBLE
import com.example.ribtest.rib.root.feed.enitity.ListItem
import com.uber.rib.core.Bundle
import com.uber.rib.core.Interactor
import com.uber.rib.core.RibInteractor
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Coordinates Business Logic for [FeedScope].
 */
@RibInteractor
class FeedInteractor : Interactor<FeedInteractor.FeedPresenter, FeedRouter>() {

    private var counter: Long = 0

    @Inject
    lateinit var presenter: FeedPresenter

    @Inject
    lateinit var listener: Listener

    var counterDisposable: Disposable? = null
    var clickDisposable: Disposable? = null
    var visibilityDisposable: Disposable? = null

    override fun didBecomeActive(savedInstanceState: Bundle?) {
        super.didBecomeActive(savedInstanceState)
        Log.d("test", "didBecomeActive")
        counter = savedInstanceState?.getString("counter")?.toLong() ?: counter

        visibilityDisposable = presenter.visibility
                .filter { visibility -> visibility == VISIBLE }
                .doOnSubscribe {
                    Log.d("test", "initVisibilityDisposable")
                    initDisposables()}
                .subscribe{ initDisposables() }
    }


    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        Log.d("test", "OnSaveInstance")
        clearDisposables()
        outState?.putString("counter", counter.toString())
    }

    private fun initDisposables(){
        if(isDisposablesEmpty()) {
            Log.d("test", "initDisposables")
            clickDisposable = presenter.clickedItem.subscribe(listener::clickOnItem)
            counterDisposable = Observable.interval(1, TimeUnit.SECONDS)
                    .map { 1L }
                    .map { value ->
                        counter += value
                        counter
                    }
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe { value -> presenter.showCounter(value) }
        }
    }

    private fun clearDisposables(){
        counterDisposable?.dispose()
        clickDisposable?.dispose()
        counterDisposable = null
        clickDisposable = null
    }

    private fun isDisposablesEmpty(): Boolean{
        return counterDisposable == null || clickDisposable == null
    }

    override fun willResignActive() {
        super.willResignActive()
        Log.d("test", "willResignActive")
        clearDisposables()
        visibilityDisposable?.dispose()
    }

    interface FeedPresenter {
        val clickedItem: Observable<ListItem>
        val visibility: Observable<Int>
        fun showCounter(count: Long)
    }

    interface Listener {
        fun clickOnItem(listItem: ListItem)
    }
}
