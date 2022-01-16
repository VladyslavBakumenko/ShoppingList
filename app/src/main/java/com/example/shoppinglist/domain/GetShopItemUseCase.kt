package com.example.shoppinglist.domain

class GetShopItemUseCase(private val shopListRepository: ShopListRepasitory) {
    suspend fun getShopItem(shopItemId: Int):ShopItem{
        return shopListRepository.getShopItem(shopItemId)
    }
}