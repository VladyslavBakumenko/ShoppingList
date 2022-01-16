package com.example.shoppinglist.presentation

import android.app.Application
import androidx.lifecycle.*
import com.example.shoppinglist.data.ShopListRepositoryImpl
import com.example.shoppinglist.domain.DeliteShopItemUseCase
import com.example.shoppinglist.domain.EditShopItemUseCase
import com.example.shoppinglist.domain.GetShopListUseCase
import com.example.shoppinglist.domain.ShopItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch


class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = ShopListRepositoryImpl(application)

    private val getShopListUseCase = GetShopListUseCase(ShopListRepositoryImpl(application))
    private val deliteShopItemUseCase = DeliteShopItemUseCase(ShopListRepositoryImpl(application))
    private val editShopListUseCase = EditShopItemUseCase(ShopListRepositoryImpl(application))


    val shopList = getShopListUseCase.getShopList()

    fun getShopList() {
        val list = getShopListUseCase.getShopList()
    }

    fun deleteShopItem(shopItem: ShopItem) {
        viewModelScope.launch {
            deliteShopItemUseCase.deliteShopItem(shopItem)
        }
    }

    fun changeEnableState(shopItem: ShopItem) {
        viewModelScope.launch {
            val newItem = shopItem.copy(enabled = !shopItem.enabled)
            editShopListUseCase.editShopItem(newItem)
        }
    }

    override fun onCleared() {
        super.onCleared()
    }
}