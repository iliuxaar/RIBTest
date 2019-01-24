package com.example.ribtest.rib.root.slidingpane.left.first

import com.uber.rib.core.RibTestBasePlaceholder
import com.uber.rib.core.InteractorHelper

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class FirstLeftInteractorTest : RibTestBasePlaceholder() {

  @Mock internal lateinit var presenter: FirstLeftInteractor.FirstLeftPresenter
  @Mock internal lateinit var router: FirstLeftRouter

  private var interactor: FirstLeftInteractor? = null

  @Before
  fun setup() {
    MockitoAnnotations.initMocks(this)

    interactor = TestFirstLeftInteractor.create(presenter)
  }

  /**
   * TODO: Delete this example and add real tests.
   */
  @Test
  fun anExampleTest_withSomeConditions_shouldPass() {
    // Use InteractorHelper to drive your interactor's lifecycle.
    InteractorHelper.attach<FirstLeftInteractor.FirstLeftPresenter, FirstLeftRouter>(interactor!!, presenter, router, null)
    InteractorHelper.detach(interactor!!)

    throw RuntimeException("Remove this test and add real tests.")
  }
}