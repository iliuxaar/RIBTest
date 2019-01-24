package com.example.ribtest.rib.root

import com.example.ribtest.rib.root.slidingpane.SlidingPaneInteractor
import com.example.ribtest.rib.root.slidingpane.SlidingPaneRouter
import com.uber.rib.core.InteractorHelper
import com.uber.rib.core.RibTestBasePlaceholder
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class SlidingPaneInteractorTest : RibTestBasePlaceholder() {

    @Mock
    internal lateinit var presenter: SlidingPaneInteractor.SlidingPanePresenter
    @Mock
    internal lateinit var router: SlidingPaneRouter

    private var interactor: SlidingPaneInteractor? = null

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)

        interactor = TestSlidingPaneInteractor.create(presenter)
    }

    /**
     * TODO: Delete this example and add real tests.
     */
    @Test
    fun anExampleTest_withSomeConditions_shouldPass() {
        // Use InteractorHelper to drive your interactor's lifecycle.
        InteractorHelper.attach<SlidingPaneInteractor.SlidingPanePresenter, SlidingPaneRouter>(interactor!!, presenter, router, null)
        InteractorHelper.detach(interactor!!)

        throw RuntimeException("Remove this test and add real tests.")
    }
}