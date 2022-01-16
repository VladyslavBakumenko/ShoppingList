package com.example.shoppinglist.domain

import androidx.lifecycle.LiveData

interface ShopListRepasitory {
    suspend fun addShopItem(shopItem: ShopItem)
    suspend fun deliteShopItem(shopItem: ShopItem)
    suspend fun editShopItem(shopItem: ShopItem)
    suspend fun getShopItem(shopItemId: Int):ShopItem
    fun getShopList(): LiveData<List<ShopItem>>
}