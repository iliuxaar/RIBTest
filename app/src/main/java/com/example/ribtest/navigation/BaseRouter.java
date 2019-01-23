package com.example.ribtest.navigation;

import android.support.annotation.Nullable;
import android.view.ViewGroup;
import com.uber.rib.core.Interactor;
import com.uber.rib.core.InteractorBaseComponent;
import com.uber.rib.core.RouterNavigatorState;
import com.uber.rib.core.ViewRouter;

public class BaseRouter<V extends ViewGroup, I extends Interactor, C extends InteractorBaseComponent, S extends RouterNavigatorState>
        extends ViewRouter<V, I, C> implements INavigationRouter<BaseRouter, S>{

    protected ViewGroup parentView;

    public BaseRouter(V view, I interactor, C component, ViewGroup parentView) {
        super(view, interactor, component);
        this.parentView = parentView;
    }

    @Override
    public BaseRouter buildRouter() {
        return this;
    }

    @Override
    public void willAttachToHost(BaseRouter router, @Nullable S previousState, S newState, boolean isPush) {
        parentView.addView(getView());
    }

    @Override
    public void willDetachFromHost(BaseRouter router, S previousState, @Nullable S newState, boolean isPush) {
        parentView.removeView(getView());
    }


}
