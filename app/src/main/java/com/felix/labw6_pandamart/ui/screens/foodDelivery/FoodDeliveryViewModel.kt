package com.felix.labw6_pandamart.ui.screens.foodDelivery

import android.view.Menu
import androidx.lifecycle.ViewModel
import com.felix.labw6_pandamart.data.DummyDataMenu
import com.felix.labw6_pandamart.model.MenuModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class FoodDeliveryViewModel: ViewModel(){
    // Private mutable state
    val _popularMenus: MutableStateFlow<List<MenuModel>> = MutableStateFlow(DummyDataMenu().PopularMenu)
    val _searchValue: MutableStateFlow<String> = MutableStateFlow("")

    // public immutable state
    val popularMenus: StateFlow<List<MenuModel>> = _popularMenus.asStateFlow()
    val searchValue : StateFlow<String> = _searchValue.asStateFlow()

    fun onSearchValueChange(newText: String){
        _searchValue.value = newText
    }
}