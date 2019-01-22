package com.example.ribtest.rib.root.red

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
 * Builder for the {@link RedScope}.
 *
 * TODO describe this scope's responsibility as a whole.
 */
class RedBuilder(dependency: ParentComponent) : ViewBuilder<RedView, RedRouter, RedBuilder.ParentComponent>(dependency) {

  /**
   * Builds a new [RedRouter].
   *
   * @param parentViewGroup parent view group that this router's view will be added to.
   * @return a new [RedRouter].
   */
  fun build(parentViewGroup: ViewGroup): RedRouter {
    val view = createView(parentViewGroup)
    val interactor = RedInteractor()
    val component = DaggerRedBuilder_Component.builder()
        .parentComponent(dependency)
        .view(view)
        .interactor(interactor)
        .build()
    return component.redRouter()
  }

  override fun inflateView(inflater: LayoutInflater, parentViewGroup: ViewGroup): RedView? {
    // TODO: Inflate a new view using the provided inflater, or create a new view programatically using the
    // provided context from the parentViewGroup.
    return null
  }

  interface ParentComponent {
    // TODO: Define dependencies required from your parent interactor here.
  }

  @dagger.Module
  abstract class Module {

    @RedScope
    @Binds
    internal abstract fun presenter(view: RedView): RedInteractor.RedPresenter

    @dagger.Module
    companion object {

      @RedScope
      @Provides
      @JvmStatic
      internal fun router(
          component: Component,
          view: RedView,
          interactor: RedInteractor): RedRouter {
        return RedRouter(view, interactor, component)
      }
    }

    // TODO: Create provider methods for dependencies created by this Rib. These should be static.
  }

  @RedScope
  @dagger.Component(modules = arrayOf(Module::class), dependencies = arrayOf(ParentComponent::class))
  interface Component : InteractorBaseComponent<RedInteractor>, BuilderComponent {

    @dagger.Component.Builder
    interface Builder {
      @BindsInstance
      fun interactor(interactor: RedInteractor): Builder

      @BindsInstance
      fun view(view: RedView): Builder

      fun parentComponent(component: ParentComponent): Builder
      fun build(): Component
    }
  }

  interface BuilderComponent {
    fun redRouter(): RedRouter
  }

  @Scope
  @Retention(CLASS)
  internal annotation class RedScope

  @Qualifier
  @Retention(CLASS)
  internal annotation class RedInternal
}
