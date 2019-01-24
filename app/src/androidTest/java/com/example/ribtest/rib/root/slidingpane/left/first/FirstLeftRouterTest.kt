package com.example.ribtest.rib.root.slidingpane.left.first

import com.uber.rib.core.RibTestBasePlaceholder
import com.uber.rib.core.RouterHelper

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class FirstLeftRouterTest : RibTestBasePlaceholder() {

    @Mock
    internal lateinit var component: FirstLeftBuilder.Component
    @Mock
    internal lateinit var interactor: FirstLeftInteractor
    @Mock
    internal lateinit var view: FirstLeftView

    private var router: FirstLeftRouter? = null

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)

        router = FirstLeftRouter(view, interactor, component)
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

