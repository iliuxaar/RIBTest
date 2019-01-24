package com.example.ribtest.rib.root.slidingpane.root.rightroot

import android.view.LayoutInflater
import android.view.ViewGroup
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
  fun build(parentViewGroup: ViewGroup): RightRootRouter {
    val view = createView(parentViewGroup)
    val interactor = RightRootInteractor()
    val component = DaggerRightRootBuilder_Component.builder()
        .parentComponent(dependency)
        .view(view)
        .interactor(interactor)
        .build()
    return component.rightrootRouter()
  }

  override fun inflateView(inflater: LayoutInflater, parentViewGroup: ViewGroup): RightRootView? {
    // TODO: Inflate a new view using the provided inflater, or create a new view programatically using the
    // provided context from the parentViewGroup.
    return null
  }

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
        return RightRootRouter(view, interactor, component)
      }
    }

    // TODO: Create provider methods for dependencies created by this Rib. These should be static.
  }

  @RightRootScope
  @dagger.Component(modules = arrayOf(Module::class), dependencies = arrayOf(ParentComponent::class))
  interface Component : InteractorBaseComponent<RightRootInteractor>, BuilderComponent {

    @dagger.Component.Builder
    interface Builder {
      @BindsInstance
      fun interactor(interactor: RightRootInteractor): Builder

      @BindsInstance
      fun view(view: RightRootView): Builder

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
