package com.example.ribtest.rib.root.slidingpane

import com.uber.rib.core.Bundle
import com.uber.rib.core.Interactor
import com.uber.rib.core.RibInteractor
import javax.inject.Inject

/**
 * Coordinates Business Logic for [SlidingPaneScope].
 *
 * TODO describe the logic of this scope.
 */
@RibInteractor
class SlidingPaneInteractor : Interactor<SlidingPaneInteractor.SlidingPanePresenter, SlidingPaneRouter>() {

    @Inject
    lateinit var presenter: SlidingPanePresenter

    override fun didBecomeActive(savedInstanceState: Bundle?) {
        super.didBecomeActive(savedInstanceState)
        router.attachLeftRoot()
        router.attachRightRoot()
    }

    interface SlidingPanePresenter
}
