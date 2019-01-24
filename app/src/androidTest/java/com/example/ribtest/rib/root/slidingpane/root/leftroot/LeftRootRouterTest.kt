package com.example.ribtest.rib.root.slidingpane.root.leftroot

import com.uber.rib.core.RibTestBasePlaceholder
import com.uber.rib.core.RouterHelper

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class LeftRootRouterTest : RibTestBasePlaceholder() {

    @Mock
    internal lateinit var component: LeftRootBuilder.Component
    @Mock
    internal lateinit var interactor: LeftRootInteractor
    @Mock
    internal lateinit var view: LeftRootView

    private var router: LeftRootRouter? = null

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)

        router = LeftRootRouter(view, interactor, component)
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

