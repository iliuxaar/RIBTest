package com.example.ribtest.rib.root.slidingpane.root.leftroot

import com.uber.rib.core.RibTestBasePlaceholder
import com.uber.rib.core.InteractorHelper

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class LeftRootInteractorTest : RibTestBasePlaceholder() {

  @Mock internal lateinit var presenter: LeftRootInteractor.LeftRootPresenter
  @Mock internal lateinit var router: LeftRootRouter

  private var interactor: LeftRootInteractor? = null

  @Before
  fun setup() {
    MockitoAnnotations.initMocks(this)

    interactor = TestLeftRootInteractor.create(presenter)
  }

  /**
   * TODO: Delete this example and add real tests.
   */
  @Test
  fun anExampleTest_withSomeConditions_shouldPass() {
    // Use InteractorHelper to drive your interactor's lifecycle.
    InteractorHelper.attach<LeftRootInteractor.LeftRootPresenter, LeftRootRouter>(interactor!!, presenter, router, null)
    InteractorHelper.detach(interactor!!)

    throw RuntimeException("Remove this test and add real tests.")
  }
}