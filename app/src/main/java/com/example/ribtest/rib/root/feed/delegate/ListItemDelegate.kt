package com.example.ribtest.rib.root.feed.delegate

import com.example.ribtest.R
import com.example.ribtest.rib.root.feed.enitity.ListItem
import com.example.ribtest.view.template.delegateadapter.BaseDelegateAdapter
import kotlinx.android.synthetic.main.delegate_list_element.*


class ListItemDelegate(private val onClick: (ListItem) -> Unit) : BaseDelegateAdapter<ListItem>() {

    override val itemLayoutId: Int get() = R.layout.delegate_list_element

    override fun BaseViewHolder.onBind(model: ListItem)  = with(itemView){
        tvListItem.text = model.text
        setOnClickListener { onClick(model) }
    }
}