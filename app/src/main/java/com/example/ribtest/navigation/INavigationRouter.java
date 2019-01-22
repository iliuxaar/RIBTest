package com.example.ribtest.navigation;

import com.uber.rib.core.Router;
import com.uber.rib.core.RouterNavigator;
import com.uber.rib.core.RouterNavigatorState;

public interface INavigationRouter<R extends Router, S extends RouterNavigatorState>
        extends RouterNavigator.AttachTransition<R, S>, RouterNavigator.DetachTransition<R, S> {
}
