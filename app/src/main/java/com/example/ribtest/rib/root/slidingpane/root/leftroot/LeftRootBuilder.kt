package com.example.ribtest.rib.root.slidingpane.root.leftroot

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.ribtest.R
import com.example.ribtest.extension.inflate
import com.example.ribtest.navigation.States
import com.example.ribtest.rib.root.slidingpane.left.first.FirstLeftBuilder
import com.example.ribtest.rib.root.slidingpane.left.first.FirstLeftInteractor
import com.example.ribtest.rib.root.slidingpane.left.second.SecondLeftBuilder
import com.uber.rib.core.InteractorBaseComponent
import com.uber.rib.core.ModernRouterNavigator
import com.uber.rib.core.ViewBuilder
import dagger.Binds
import dagger.BindsInstance
import dagger.Provides
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy.CLASS
import javax.inject.Qualifier
import javax.inject.Scope

/**
 * Builder for the {@link LeftRootScope}.
 *
 * TODO describe this scope's responsibility as a whole.
 */
class LeftRootBuilder(dependency: ParentComponent) : ViewBuilder<LeftRootView, LeftRootRouter, LeftRootBuilder.ParentComponent>(dependency) {

    /**
     * Builds a new [LeftRootRouter].
     *
     * @param parentViewGroup parent view group that this router's view will be added to.
     * @return a new [LeftRootRouter].
     */
    fun build(parentViewGroup: ViewGroup, navigator: ModernRouterNavigator<States>): LeftRootRouter {
        val view = createView(parentViewGroup)
        val interactor = LeftRootInteractor()
        val component = DaggerLeftRootBuilder_Component.builder()
                .parentComponent(dependency)
                .view(view)
                .navigator(navigator)
                .interactor(interactor)
                .build()
        return component.leftrootRouter()
    }

    override fun inflateView(inflater: LayoutInflater, parentViewGroup: ViewGroup) =
            parentViewGroup.inflate<LeftRootView>(R.layout.rib_left_root)

    interface ParentComponent {
        // TODO: Define dependencies required from your parent interactor here.
    }

    @dagger.Module
    abstract class Module {

        @LeftRootScope
        @Binds
        internal abstract fun presenter(view: LeftRootView): LeftRootInteractor.LeftRootPresenter

        @dagger.Module
        companion object {

            @LeftRootScope
            @Provides
            @JvmStatic
            internal fun router(
                    component: Component,
                    view: LeftRootView,
                    interactor: LeftRootInteractor): LeftRootRouter {
                return LeftRootRouter(view, interactor, component, FirstLeftBuilder(component), SecondLeftBuilder(component))
            }

            @LeftRootScope
            @Provides
            @JvmStatic
            internal fun FirstLeftListener(interactor: LeftRootInteractor): FirstLeftInteractor.GreenListener =
                    interactor.FirstLeftListener()

        }

        // TODO: Create provider methods for dependencies created by this Rib. These should be static.
    }

    @LeftRootScope
    @dagger.Component(modules = arrayOf(Module::class), dependencies = arrayOf(ParentComponent::class))
    interface Component :
            InteractorBaseComponent<LeftRootInteractor>,
            FirstLeftBuilder.ParentComponent,
            SecondLeftBuilder.ParentComponent,
            BuilderComponent {

        @dagger.Component.Builder
        interface Builder {
            @BindsInstance
            fun interactor(interactor: LeftRootInteractor): Builder

            @BindsInstance
            fun view(view: LeftRootView): Builder

            @BindsInstance
            fun navigator(navigator: ModernRouterNavigator<States>): Builder

            fun parentComponent(component: ParentComponent): Builder
            fun build(): Component
        }
    }

    interface BuilderComponent {
        fun leftrootRouter(): LeftRootRouter
    }

    @Scope
    @Retention(CLASS)
    internal annotation class LeftRootScope

    @Qualifier
    @Retention(CLASS)
    internal annotation class LeftRootInternal
}
