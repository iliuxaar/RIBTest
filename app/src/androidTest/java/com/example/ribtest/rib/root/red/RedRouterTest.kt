package com.example.ribtest.rib.root.red

import com.uber.rib.core.RibTestBasePlaceholder
import com.uber.rib.core.RouterHelper

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class RedRouterTest : RibTestBasePlaceholder() {

  @Mock internal lateinit var component: RedBuilder.Component
  @Mock internal lateinit var interactor: RedInteractor
  @Mock internal lateinit var view: RedView

  private var router: RedRouter? = null

  @Before
  fun setup() {
    MockitoAnnotations.initMocks(this)

    router = RedRouter(view, interactor, component)
  }

  /**
   * TODO: Delete this example and add real tests.
   */
  @Test
  fun anExampleTest_withSomeConditions_shouldPass() {
    // Use RouterHelper to drive your router's lifecycle.
    RouterHelper.attach(router!!)
    RouterHelper.detach(router!!)

    throw RuntimeException("Remove this test and add real tests.")
  }

}

