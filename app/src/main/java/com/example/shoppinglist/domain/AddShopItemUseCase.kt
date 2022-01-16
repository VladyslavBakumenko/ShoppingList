package com.example.shoppinglist.domain

class AddShopItemUseCase(private val shopListRepository: ShopListRepasitory) {
    suspend fun addShopItem(shopItem: ShopItem){
        shopListRepository.addShopItem(shopItem)
    }
}