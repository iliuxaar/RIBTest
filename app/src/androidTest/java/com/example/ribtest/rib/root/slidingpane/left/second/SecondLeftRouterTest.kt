package com.example.ribtest.rib.root.slidingpane.left.second

import com.uber.rib.core.RibTestBasePlaceholder
import com.uber.rib.core.RouterHelper

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class SecondLeftRouterTest : RibTestBasePlaceholder() {

    @Mock
    internal lateinit var component: SecondLeftBuilder.Component
    @Mock
    internal lateinit var interactor: SecondLeftInteractor
    @Mock
    internal lateinit var view: SecondLeftView

    private var router: SecondLeftRouter? = null

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)

        router = SecondLeftRouter(view, interactor, component)
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

