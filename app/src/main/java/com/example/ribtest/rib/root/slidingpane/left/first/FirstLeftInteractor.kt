package com.example.ribtest.rib.root.slidingpane.left.first

import com.uber.rib.core.Bundle
import com.uber.rib.core.Interactor
import com.uber.rib.core.RibInteractor
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Coordinates Business Logic for [FirstLeftScope].
 *
 * TODO describe the logic of this scope.
 */
@RibInteractor
class FirstLeftInteractor : Interactor<FirstLeftInteractor.FirstLeftPresenter, FirstLeftRouter>() {

    @Inject
    lateinit var presenter: FirstLeftPresenter

    @Inject
    lateinit var greenListener: GreenListener

    override fun didBecomeActive(savedInstanceState: Bundle?) {
        super.didBecomeActive(savedInstanceState)

        presenter.buttonClick().subscribe { greenListener.nextScreen() }
    }

    override fun willResignActive() {
        super.willResignActive()

        // TODO: Perform any required clean up here, or delete this method entirely if not needed.
    }

    /**
     * Presenter interface implemented by this RIB's view.
     */
    interface FirstLeftPresenter {
        fun buttonClick(): Observable<Any>
    }

    interface GreenListener {
        fun nextScreen();
    }
}
