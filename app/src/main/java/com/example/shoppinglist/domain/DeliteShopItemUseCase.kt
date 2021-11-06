package com.example.shoppinglist.domain

class DeliteShopItemUseCase(private val shopListRepository: ShopListRepasitory) {
    fun deliteShopItem(shopItem: ShopItem){
        shopListRepository.deliteShopItem(shopItem)
    }
}