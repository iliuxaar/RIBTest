package com.example.ribtest.rib.root.slidingpane.left.second

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.ribtest.R
import com.example.ribtest.extension.inflate
import com.example.ribtest.rib.root.slidingpane.root.leftroot.LeftRootView
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
 * Builder for the {@link SecondLeftScope}.
 *
 * TODO describe this scope's responsibility as a whole.
 */
class SecondLeftBuilder(dependency: ParentComponent) : ViewBuilder<SecondLeftView, SecondLeftRouter, SecondLeftBuilder.ParentComponent>(dependency) {

    /**
     * Builds a new [SecondLeftRouter].
     *
     * @param parentViewGroup parent view group that this router's view will be added to.
     * @return a new [SecondLeftRouter].
     */
    fun build(parentViewGroup: ViewGroup): SecondLeftRouter {
        val view = createView(parentViewGroup)
        val interactor = SecondLeftInteractor()
        val component = DaggerSecondLeftBuilder_Component.builder()
                .parentComponent(dependency)
                .view(view)
                .interactor(interactor)
                .build()
        return component.secondleftRouter()
    }

    override fun inflateView(inflater: LayoutInflater, parentViewGroup: ViewGroup) =
            parentViewGroup.inflate<SecondLeftView>(R.layout.rib_second_left)

    interface ParentComponent {
        fun slidePaneView(): LeftRootView
    }

    @dagger.Module
    abstract class Module {

        @SecondLeftScope
        @Binds
        internal abstract fun presenter(view: SecondLeftView): SecondLeftInteractor.SecondLeftPresenter

        @dagger.Module
        companion object {

            @SecondLeftScope
            @Provides
            @JvmStatic
            internal fun router(
                    component: Component,
                    view: SecondLeftView,
                    interactor: SecondLeftInteractor,
                    parentView: LeftRootView): SecondLeftRouter {
                return SecondLeftRouter(view, interactor, component, parentView)
            }
        }

        // TODO: Create provider methods for dependencies created by this Rib. These should be static.
    }

    @SecondLeftScope
    @dagger.Component(modules = arrayOf(Module::class), dependencies = arrayOf(ParentComponent::class))
    interface Component : InteractorBaseComponent<SecondLeftInteractor>, BuilderComponent {

        @dagger.Component.Builder
        interface Builder {
            @BindsInstance
            fun interactor(interactor: SecondLeftInteractor): Builder

            @BindsInstance
            fun view(view: SecondLeftView): Builder

            fun parentComponent(component: ParentComponent): Builder
            fun build(): Component
        }
    }

    interface BuilderComponent {
        fun secondleftRouter(): SecondLeftRouter
    }

    @Scope
    @Retention(CLASS)
    internal annotation class SecondLeftScope

    @Qualifier
    @Retention(CLASS)
    internal annotation class SecondLeftInternal
}
