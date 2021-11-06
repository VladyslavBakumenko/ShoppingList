package com.example.shoppinglist.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ListAdapter
import com.example.shoppinglist.R
import com.example.shoppinglist.domain.ShopItem

class ShopListAdapter : ListAdapter<ShopItem, ShopItemViewHolder>(ShopItemDiffCallback()) {


    var onShopItemLongClickListener: ((ShopItem) -> Unit)? = null
    var onShopItemClickListener: ((ShopItem) -> Unit)? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder {

        val layout = when (viewType) {
            VIEV_TYPE_DESABLED -> R.layout.item_shop_disabled
            VIEV_TYPE_ENABLED -> R.layout.item_shop_enabled
            else -> throw RuntimeException("unknown viewType $viewType")
        }
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return ShopItemViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ShopItemViewHolder, position: Int) {
        val shopItem = getItem(position)
        viewHolder.view.setOnLongClickListener {
            onShopItemLongClickListener?.invoke(shopItem)
            true
        }
        viewHolder.view.setOnClickListener {
            onShopItemClickListener?.invoke(shopItem)
            true
        }
        if (shopItem.enabled) {
            viewHolder.tvName.text = "${shopItem.name}"
            viewHolder.tvCount.text = shopItem.count.toString()
            viewHolder.tvName.setTextColor(
                (ContextCompat.getColor(
                    viewHolder.view.context,
                    android.R.color.holo_blue_bright
                ))
            )
        } else {
            viewHolder.tvName.text = "${shopItem.name}"
            viewHolder.tvCount.text = shopItem.count.toString()
            viewHolder.tvName.setTextColor(
                (ContextCompat.getColor(
                    viewHolder.view.context,
                    android.R.color.holo_blue_bright
                ))
            )
        }
    }


    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return if (item.enabled) {
            VIEV_TYPE_ENABLED
        } else {
            VIEV_TYPE_DESABLED
        }

    }


    companion object {
        const val VIEV_TYPE_ENABLED = 100
        const val VIEV_TYPE_DESABLED = 101
        const val MAX_POOL_SIZE = 15
    }
}
