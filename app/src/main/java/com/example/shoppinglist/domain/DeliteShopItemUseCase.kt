package com.example.shoppinglist.domain

class DeliteShopItemUseCase(private val shopListRepository: ShopListRepasitory) {
    suspend fun deliteShopItem(shopItem: ShopItem){
        shopListRepository.deliteShopItem(shopItem)
    }
}