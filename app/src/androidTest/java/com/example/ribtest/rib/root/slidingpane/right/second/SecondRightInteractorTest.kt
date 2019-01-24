package com.example.ribtest.rib.root.slidingpane.right.second

import com.uber.rib.core.RibTestBasePlaceholder
import com.uber.rib.core.InteractorHelper

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class SecondRightInteractorTest : RibTestBasePlaceholder() {

  @Mock internal lateinit var presenter: SecondRightInteractor.SecondRightPresenter
  @Mock internal lateinit var router: SecondRightRouter

  private var interactor: SecondRightInteractor? = null

  @Before
  fun setup() {
    MockitoAnnotations.initMocks(this)

    interactor = TestSecondRightInteractor.create(presenter)
  }

  /**
   * TODO: Delete this example and add real tests.
   */
  @Test
  fun anExampleTest_withSomeConditions_shouldPass() {
    // Use InteractorHelper to drive your interactor's lifecycle.
    InteractorHelper.attach<SecondRightInteractor.SecondRightPresenter, SecondRightRouter>(interactor!!, presenter, router, null)
    InteractorHelper.detach(interactor!!)

    throw RuntimeException("Remove this test and add real tests.")
  }
}