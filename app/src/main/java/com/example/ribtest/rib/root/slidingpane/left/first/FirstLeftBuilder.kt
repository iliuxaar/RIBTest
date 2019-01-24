package com.example.ribtest.rib.root.slidingpane.left.first

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.ribtest.R
import com.example.ribtest.extension.inflate
import com.example.ribtest.rib.root.slidingpane.SlidingPaneView
import com.uber.rib.core.InteractorBaseComponent
import com.uber.rib.core.ViewBuilder
import dagger.Binds
import dagger.BindsInstance
import dagger.Provides
import kotlinx.android.synthetic.main.rib_sliding_pane.view.*
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy.CLASS
import javax.inject.Qualifier
import javax.inject.Scope

/**
 * Builder for the {@link FirstLeftScope}.
 *
 * TODO describe this scope's responsibility as a whole.
 */
class FirstLeftBuilder(dependency: ParentComponent) : ViewBuilder<FirstLeftView, FirstLeftRouter, FirstLeftBuilder.ParentComponent>(dependency) {

  /**
   * Builds a new [FirstLeftRouter].
   *
   * @param parentViewGroup parent view group that this router's view will be added to.
   * @return a new [FirstLeftRouter].
   */
  fun build(parentViewGroup: ViewGroup): FirstLeftRouter {
    val view = createView(parentViewGroup)
    val interactor = FirstLeftInteractor()
    val component = DaggerFirstLeftBuilder_Component.builder()
        .parentComponent(dependency)
        .view(view)
        .interactor(interactor)
        .build()
    return component.firstleftRouter()
  }

  override fun inflateView(inflater: LayoutInflater, parentViewGroup: ViewGroup) =
      parentViewGroup.inflate<FirstLeftView>(R.layout.rib_first_left)

  interface ParentComponent {
      val firstLeftListener: FirstLeftInteractor.GreenListener
      fun slidePaneView(): SlidingPaneView
  }

  @dagger.Module
  abstract class Module {

    @FirstLeftScope
    @Binds
    internal abstract fun presenter(view: FirstLeftView): FirstLeftInteractor.FirstLeftPresenter

    @dagger.Module
    companion object {

      @FirstLeftScope
      @Provides
      @JvmStatic
      internal fun router(
          component: Component,
          view: FirstLeftView,
          interactor: FirstLeftInteractor,
          parentView: SlidingPaneView): FirstLeftRouter {
        return FirstLeftRouter(view, interactor, component, parentView.left_container)
      }
    }

    // TODO: Create provider methods for dependencies created by this Rib. These should be static.
  }

  @FirstLeftScope
  @dagger.Component(modules = arrayOf(Module::class), dependencies = arrayOf(ParentComponent::class))
  interface Component : InteractorBaseComponent<FirstLeftInteractor>, BuilderComponent {

    @dagger.Component.Builder
    interface Builder {
      @BindsInstance
      fun interactor(interactor: FirstLeftInteractor): Builder

      @BindsInstance
      fun view(view: FirstLeftView): Builder

      fun parentComponent(component: ParentComponent): Builder
      fun build(): Component
    }
  }

  interface BuilderComponent {
    fun firstleftRouter(): FirstLeftRouter
  }

  @Scope
  @Retention(CLASS)
  internal annotation class FirstLeftScope

  @Qualifier
  @Retention(CLASS)
  internal annotation class FirstLeftInternal
}
