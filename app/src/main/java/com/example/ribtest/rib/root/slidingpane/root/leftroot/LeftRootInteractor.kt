package com.example.ribtest.rib.root.slidingpane.root.leftroot

import com.uber.rib.core.Bundle
import com.uber.rib.core.Interactor
import com.uber.rib.core.RibInteractor
import javax.inject.Inject

/**
 * Coordinates Business Logic for [LeftRootScope].
 *
 * TODO describe the logic of this scope.
 */
@RibInteractor
class LeftRootInteractor : Interactor<LeftRootInteractor.LeftRootPresenter, LeftRootRouter>() {

  @Inject
  lateinit var presenter: LeftRootPresenter

  override fun didBecomeActive(savedInstanceState: Bundle?) {
    super.didBecomeActive(savedInstanceState)

    // TODO: Add attachment logic here (RxSubscriptions, etc.).
  }

  override fun willResignActive() {
    super.willResignActive()

    // TODO: Perform any required clean up here, or delete this method entirely if not needed.
  }

  /**
   * Presenter interface implemented by this RIB's view.
   */
  interface LeftRootPresenter
}
