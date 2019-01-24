package com.example.ribtest.rib.root.slidingpane.right.first

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.ribtest.R
import com.example.ribtest.extension.inflate
import com.example.ribtest.rib.root.slidingpane.SlidingPaneView
import com.example.ribtest.rib.root.slidingpane.left.first.FirstLeftInteractor
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
 * Builder for the {@link FirstRightScope}.
 *
 * TODO describe this scope's responsibility as a whole.
 */
class FirstRightBuilder(dependency: ParentComponent) : ViewBuilder<FirstRightView, FirstRightRouter, FirstRightBuilder.ParentComponent>(dependency) {

  /**
   * Builds a new [FirstRightRouter].
   *
   * @param parentViewGroup parent view group that this router's view will be added to.
   * @return a new [FirstRightRouter].
   */
  fun build(parentViewGroup: ViewGroup): FirstRightRouter {
    val view = createView(parentViewGroup)
    val interactor = FirstRightInteractor()
    val component = DaggerFirstRightBuilder_Component.builder()
        .parentComponent(dependency)
        .view(view)
        .interactor(interactor)
        .build()
    return component.firstrightRouter()
  }

  override fun inflateView(inflater: LayoutInflater, parentViewGroup: ViewGroup) =
          parentViewGroup.inflate<FirstRightView>(R.layout.rib_first_right)

  interface ParentComponent {
      val firstRightListener: FirstRightInteractor.OrangeListener
      fun slidePaneView(): SlidingPaneView
  }

  @dagger.Module
  abstract class Module {

    @FirstRightScope
    @Binds
    internal abstract fun presenter(view: FirstRightView): FirstRightInteractor.FirstRightPresenter

    @dagger.Module
    companion object {

      @FirstRightScope
      @Provides
      @JvmStatic
      internal fun router(
          component: Component,
          view: FirstRightView,
          interactor: FirstRightInteractor,
          parentView: SlidingPaneView): FirstRightRouter {
        return FirstRightRouter(view, interactor, component, parentView.right_container)
      }
    }

    // TODO: Create provider methods for dependencies created by this Rib. These should be static.
  }

  @FirstRightScope
  @dagger.Component(modules = arrayOf(Module::class), dependencies = arrayOf(ParentComponent::class))
  interface Component : InteractorBaseComponent<FirstRightInteractor>, BuilderComponent {

    @dagger.Component.Builder
    interface Builder {
      @BindsInstance
      fun interactor(interactor: FirstRightInteractor): Builder

      @BindsInstance
      fun view(view: FirstRightView): Builder

      fun parentComponent(component: ParentComponent): Builder
      fun build(): Component
    }
  }

  interface BuilderComponent {
    fun firstrightRouter(): FirstRightRouter
  }

  @Scope
  @Retention(CLASS)
  internal annotation class FirstRightScope

  @Qualifier
  @Retention(CLASS)
  internal annotation class FirstRightInternal
}
