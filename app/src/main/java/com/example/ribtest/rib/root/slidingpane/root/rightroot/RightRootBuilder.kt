package com.example.ribtest.rib.root.slidingpane.root.rightroot

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.ribtest.R
import com.example.ribtest.extension.inflate
import com.example.ribtest.navigation.States
import com.example.ribtest.rib.root.slidingpane.right.first.FirstRightBuilder
import com.example.ribtest.rib.root.slidingpane.right.first.FirstRightInteractor
import com.example.ribtest.rib.root.slidingpane.right.second.SecondRightBuilder
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
 * Builder for the {@link RightRootScope}.
 *
 * TODO describe this scope's responsibility as a whole.
 */
class RightRootBuilder(dependency: ParentComponent) : ViewBuilder<RightRootView, RightRootRouter, RightRootBuilder.ParentComponent>(dependency) {

    /**
     * Builds a new [RightRootRouter].
     *
     * @param parentViewGroup parent view group that this router's view will be added to.
     * @return a new [RightRootRouter].
     */
    fun build(parentViewGroup: ViewGroup, navigator: ModernRouterNavigator<States>): RightRootRouter {
        val view = createView(parentViewGroup)
        val interactor = RightRootInteractor()
        val component = DaggerRightRootBuilder_Component.builder()
                .parentComponent(dependency)
                .view(view)
                .navigator(navigator)
                .interactor(interactor)
                .build()
        return component.rightrootRouter()
    }

    override fun inflateView(inflater: LayoutInflater, parentViewGroup: ViewGroup) =
            parentViewGroup.inflate<RightRootView>(R.layout.rib_right_root)

    interface ParentComponent {
        // TODO: Define dependencies required from your parent interactor here.
    }

    @dagger.Module
    abstract class Module {

        @RightRootScope
        @Binds
        internal abstract fun presenter(view: RightRootView): RightRootInteractor.RightRootPresenter

        @dagger.Module
        companion object {

            @RightRootScope
            @Provides
            @JvmStatic
            internal fun router(
                    component: Component,
                    view: RightRootView,
                    interactor: RightRootInteractor): RightRootRouter {
                return RightRootRouter(view, interactor, component, FirstRightBuilder(component), SecondRightBuilder(component))
            }

            @RightRootScope
            @Provides
            @JvmStatic
            internal fun FirstRightListener(interactor: RightRootInteractor): FirstRightInteractor.OrangeListener =
                    interactor.FirstRightListener()
        }

        // TODO: Create provider methods for dependencies created by this Rib. These should be static.
    }

    @RightRootScope
    @dagger.Component(modules = arrayOf(Module::class), dependencies = arrayOf(ParentComponent::class))
    interface Component :
            InteractorBaseComponent<RightRootInteractor>,
            FirstRightBuilder.ParentComponent,
            SecondRightBuilder.ParentComponent,
            BuilderComponent {

        @dagger.Component.Builder
        interface Builder {
            @BindsInstance
            fun interactor(interactor: RightRootInteractor): Builder

            @BindsInstance
            fun view(view: RightRootView): Builder

            @BindsInstance
            fun navigator(navigator: ModernRouterNavigator<States>): Builder

            fun parentComponent(component: ParentComponent): Builder
            fun build(): Component
        }
    }

    interface BuilderComponent {
        fun rightrootRouter(): RightRootRouter
    }

    @Scope
    @Retention(CLASS)
    internal annotation class RightRootScope

    @Qualifier
    @Retention(CLASS)
    internal annotation class RightRootInternal
}
