package com.example.ribtest.rib.root.slidingpane

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.ribtest.R
import com.example.ribtest.extension.inflate
import com.example.ribtest.rib.root.RootView
import com.example.ribtest.rib.root.slidingpane.root.leftroot.LeftRootBuilder
import com.example.ribtest.rib.root.slidingpane.root.rightroot.RightRootBuilder
import com.uber.rib.core.InteractorBaseComponent
import com.uber.rib.core.ViewBuilder
import dagger.Binds
import dagger.BindsInstance
import dagger.Provides
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy.CLASS
import javax.inject.Qualifier
import javax.inject.Scope

/**
 * Builder for the {@link SlidingPaneScope}.
 *
 * TODO describe this scope's responsibility as a whole.
 */
class SlidingPaneBuilder(dependency: ParentComponent) : ViewBuilder<SlidingPaneView, SlidingPaneRouter, SlidingPaneBuilder.ParentComponent>(dependency) {

    /**
     * Builds a new [SlidingPaneRouter].
     *
     * @param parentViewGroup parent view group that this router's view will be added to.
     * @return a new [SlidingPaneRouter].
     */
    fun build(parentViewGroup: ViewGroup): SlidingPaneRouter {
        val view = createView(parentViewGroup)
        val interactor = SlidingPaneInteractor()
        val component = DaggerSlidingPaneBuilder_Component.builder()
                .parentComponent(dependency)
                .view(view)
                .interactor(interactor)
                .build()
        return component.slidingpaneRouter()
    }

    override fun inflateView(inflater: LayoutInflater, parentViewGroup: ViewGroup) =
            parentViewGroup.inflate<SlidingPaneView>(R.layout.rib_sliding_pane)

    interface ParentComponent {
        fun parentView(): RootView
    }

    @dagger.Module
    abstract class Module {

        @SlidingPaneScope
        @Binds
        internal abstract fun presenter(view: SlidingPaneView): SlidingPaneInteractor.SlidingPanePresenter

        @dagger.Module
        companion object {

            @SlidingPaneScope
            @Provides
            @JvmStatic
            internal fun router(
                    component: Component,
                    view: SlidingPaneView,
                    interactor: SlidingPaneInteractor,
                    parentView: RootView
            ): SlidingPaneRouter {
                return SlidingPaneRouter(view, interactor, component, parentView, LeftRootBuilder(component), RightRootBuilder(component))
            }
        }
    }

    @SlidingPaneScope
    @dagger.Component(modules = arrayOf(Module::class), dependencies = arrayOf(
            ParentComponent::class))
    interface Component : InteractorBaseComponent<SlidingPaneInteractor>,
            LeftRootBuilder.ParentComponent,
            RightRootBuilder.ParentComponent,
            BuilderComponent {

        @dagger.Component.Builder
        interface Builder {
            @BindsInstance
            fun interactor(interactor: SlidingPaneInteractor): Builder

            @BindsInstance
            fun view(view: SlidingPaneView): Builder

            fun parentComponent(component: ParentComponent): Builder
            fun build(): Component
        }
    }

    interface BuilderComponent {
        fun slidingpaneRouter(): SlidingPaneRouter
    }

    @Scope
    @Retention(CLASS)
    internal annotation class SlidingPaneScope

    @Qualifier
    @Retention(CLASS)
    internal annotation class SlidingPaneInternal
}
