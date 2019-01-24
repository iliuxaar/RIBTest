package com.example.ribtest.rib.root.slidingpane.right.first

import com.uber.rib.core.Bundle
import com.uber.rib.core.Interactor
import com.uber.rib.core.RibInteractor
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Coordinates Business Logic for [FirstRightScope].
 *
 * TODO describe the logic of this scope.
 */
@RibInteractor
class FirstRightInteractor : Interactor<FirstRightInteractor.FirstRightPresenter, FirstRightRouter>() {

  @Inject
  lateinit var presenter: FirstRightPresenter

  @Inject
  lateinit var orangeListener: OrangeListener

  override fun didBecomeActive(savedInstanceState: Bundle?) {
    super.didBecomeActive(savedInstanceState)

    presenter.buttonClick().subscribe { orangeListener.nextScreen() }
  }

  override fun willResignActive() {
    super.willResignActive()

  }

  /**
   * Presenter interface implemented by this RIB's view.
   */
  interface FirstRightPresenter{
      fun buttonClick(): Observable<Any>
  }

  interface OrangeListener{
      fun nextScreen();
  }
}
