package com.example.shoppinglist.domain

import androidx.lifecycle.LiveData

interface ShopListRepasitory {
    fun addShopItem(shopItem: ShopItem)
    fun deliteShopItem(shopItem: ShopItem)
    fun editShopItem(shopItem: ShopItem)
    fun getShopItem(shopItemId: Int):ShopItem
    fun getShopList(): LiveData<List<ShopItem>>
}