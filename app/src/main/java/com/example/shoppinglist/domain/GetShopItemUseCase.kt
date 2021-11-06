package com.example.shoppinglist.domain

class GetShopItemUseCase(private val shopListRepository: ShopListRepasitory) {
    fun getShopItem(shopItemId: Int):ShopItem{
        return shopListRepository.getShopItem(shopItemId)
    }
}