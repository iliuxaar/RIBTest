package com.example.ribtest.rib.root.slidingpane.left.second

import com.uber.rib.core.RibTestBasePlaceholder
import com.uber.rib.core.InteractorHelper

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class SecondLeftInteractorTest : RibTestBasePlaceholder() {

  @Mock internal lateinit var presenter: SecondLeftInteractor.SecondLeftPresenter
  @Mock internal lateinit var router: SecondLeftRouter

  private var interactor: SecondLeftInteractor? = null

  @Before
  fun setup() {
    MockitoAnnotations.initMocks(this)

    interactor = TestSecondLeftInteractor.create(presenter)
  }

  /**
   * TODO: Delete this example and add real tests.
   */
  @Test
  fun anExampleTest_withSomeConditions_shouldPass() {
    // Use InteractorHelper to drive your interactor's lifecycle.
    InteractorHelper.attach<SecondLeftInteractor.SecondLeftPresenter, SecondLeftRouter>(interactor!!, presenter, router, null)
    InteractorHelper.detach(interactor!!)

    throw RuntimeException("Remove this test and add real tests.")
  }
}