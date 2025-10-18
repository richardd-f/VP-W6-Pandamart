package com.felix.labw6_pandamart.ui.screens.pandamart

import androidx.lifecycle.ViewModel
import com.felix.labw6_pandamart.data.DummyDataMenu
import com.felix.labw6_pandamart.model.MenuModel
import kotlinx.coroutines.flow.MutableStateFlow

class PandamartViewModel : ViewModel() {
    // Default Value
    val featuredProducts: MutableStateFlow<List<MenuModel>> = MutableStateFlow(DummyDataMenu().FeaturedProduct)

    // private mutable
    private val _searchValue: MutableStateFlow<String> = MutableStateFlow("")

    // public immutable
    val searchValue: MutableStateFlow<String> = _searchValue

    // events
    fun onSearchValueChange(text:String){
        _searchValue.value = text
    }
}