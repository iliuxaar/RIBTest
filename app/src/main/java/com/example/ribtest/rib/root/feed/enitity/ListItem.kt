package com.example.ribtest.rib.root.feed.enitity

import com.example.ribtest.view.LIST_ITEM
import com.example.ribtest.view.template.delegateadapter.DelegateViewType

data class ListItem(val text: String) : DelegateViewType {
    override val viewType: Int
        get() = LIST_ITEM
}