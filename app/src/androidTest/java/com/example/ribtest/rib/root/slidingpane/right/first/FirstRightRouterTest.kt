package com.example.ribtest.rib.root.slidingpane.right.first

import com.uber.rib.core.RibTestBasePlaceholder
import com.uber.rib.core.RouterHelper

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class FirstRightRouterTest : RibTestBasePlaceholder() {

    @Mock
    internal lateinit var component: FirstRightBuilder.Component
    @Mock
    internal lateinit var interactor: FirstRightInteractor
    @Mock
    internal lateinit var view: FirstRightView

    private var router: FirstRightRouter? = null

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)

        router = FirstRightRouter(view, interactor, component)
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

