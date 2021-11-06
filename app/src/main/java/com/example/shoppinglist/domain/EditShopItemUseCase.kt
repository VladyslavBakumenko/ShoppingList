package com.example.shoppinglist.domain

class EditShopItemUseCase(private val shopListRepository: ShopListRepasitory) {
    fun editShopItem(shopItem: ShopItem){
        shopListRepository.editShopItem(shopItem)
    }
}