package com.example.ribtest.rib.root.slidingpane.root.rightroot

import com.uber.rib.core.RibTestBasePlaceholder
import com.uber.rib.core.InteractorHelper

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class RightRootInteractorTest : RibTestBasePlaceholder() {

  @Mock internal lateinit var presenter: RightRootInteractor.RightRootPresenter
  @Mock internal lateinit var router: RightRootRouter

  private var interactor: RightRootInteractor? = null

  @Before
  fun setup() {
    MockitoAnnotations.initMocks(this)

    interactor = TestRightRootInteractor.create(presenter)
  }

  /**
   * TODO: Delete this example and add real tests.
   */
  @Test
  fun anExampleTest_withSomeConditions_shouldPass() {
    // Use InteractorHelper to drive your interactor's lifecycle.
    InteractorHelper.attach<RightRootInteractor.RightRootPresenter, RightRootRouter>(interactor!!, presenter, router, null)
    InteractorHelper.detach(interactor!!)

    throw RuntimeException("Remove this test and add real tests.")
  }
}