package com.example.ribtest.rib.root.slidingpane.right.first

import com.uber.rib.core.RibTestBasePlaceholder
import com.uber.rib.core.InteractorHelper

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class FirstRightInteractorTest : RibTestBasePlaceholder() {

  @Mock internal lateinit var presenter: FirstRightInteractor.FirstRightPresenter
  @Mock internal lateinit var router: FirstRightRouter

  private var interactor: FirstRightInteractor? = null

  @Before
  fun setup() {
    MockitoAnnotations.initMocks(this)

    interactor = TestFirstRightInteractor.create(presenter)
  }

  /**
   * TODO: Delete this example and add real tests.
   */
  @Test
  fun anExampleTest_withSomeConditions_shouldPass() {
    // Use InteractorHelper to drive your interactor's lifecycle.
    InteractorHelper.attach<FirstRightInteractor.FirstRightPresenter, FirstRightRouter>(interactor!!, presenter, router, null)
    InteractorHelper.detach(interactor!!)

    throw RuntimeException("Remove this test and add real tests.")
  }
}