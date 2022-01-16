package com.example.shoppinglist.data

import com.example.shoppinglist.domain.ShopItem

class ShopListMapper {
    fun  mapEntityToDbModel(shopItem: ShopItem): ShopItemDbModel {
        return ShopItemDbModel(
            shopItem.id,
            shopItem.name,
            shopItem.count,
            shopItem.enabled
        )
    }

    fun  mapDbModelToEntity(shopItemDbModel: ShopItemDbModel): ShopItem {
        return ShopItem(
            shopItemDbModel.name,
            shopItemDbModel.count,
            shopItemDbModel.enabled,
            shopItemDbModel.id
        )
    }

    fun mapListDbModelToListEntity(list: List<ShopItemDbModel>) = list.map {
        mapDbModelToEntity(it)
    }
}