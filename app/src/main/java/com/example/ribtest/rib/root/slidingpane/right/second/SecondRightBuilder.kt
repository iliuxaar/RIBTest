package com.example.ribtest.rib.root.slidingpane.right.second

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
 * Builder for the {@link SecondRightScope}.
 *
 * TODO describe this scope's responsibility as a whole.
 */
class SecondRightBuilder(dependency: ParentComponent) : ViewBuilder<SecondRightView, SecondRightRouter, SecondRightBuilder.ParentComponent>(dependency) {

  /**
   * Builds a new [SecondRightRouter].
   *
   * @param parentViewGroup parent view group that this router's view will be added to.
   * @return a new [SecondRightRouter].
   */
  fun build(parentViewGroup: ViewGroup): SecondRightRouter {
    val view = createView(parentViewGroup)
    val interactor = SecondRightInteractor()
    val component = DaggerSecondRightBuilder_Component.builder()
        .parentComponent(dependency)
        .view(view)
        .interactor(interactor)
        .build()
    return component.secondrightRouter()
  }

  override fun inflateView(inflater: LayoutInflater, parentViewGroup: ViewGroup) =
          parentViewGroup.inflate<SecondRightView>(R.layout.rib_second_right)

  interface ParentComponent {
    fun slidePaneView(): SlidingPaneView
  }

  @dagger.Module
  abstract class Module {

    @SecondRightScope
    @Binds
    internal abstract fun presenter(view: SecondRightView): SecondRightInteractor.SecondRightPresenter

    @dagger.Module
    companion object {

      @SecondRightScope
      @Provides
      @JvmStatic
      internal fun router(
          component: Component,
          view: SecondRightView,
          interactor: SecondRightInteractor,
          parentView: SlidingPaneView): SecondRightRouter {
        return SecondRightRouter(view, interactor, component, parentView.right_container)
      }
    }

    // TODO: Create provider methods for dependencies created by this Rib. These should be static.
  }

  @SecondRightScope
  @dagger.Component(modules = arrayOf(Module::class), dependencies = arrayOf(ParentComponent::class))
  interface Component : InteractorBaseComponent<SecondRightInteractor>, BuilderComponent {

    @dagger.Component.Builder
    interface Builder {
      @BindsInstance
      fun interactor(interactor: SecondRightInteractor): Builder

      @BindsInstance
      fun view(view: SecondRightView): Builder

      fun parentComponent(component: ParentComponent): Builder
      fun build(): Component
    }
  }

  interface BuilderComponent {
    fun secondrightRouter(): SecondRightRouter
  }

  @Scope
  @Retention(CLASS)
  internal annotation class SecondRightScope

  @Qualifier
  @Retention(CLASS)
  internal annotation class SecondRightInternal
}
