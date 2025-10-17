package com.felix.labw6_pandamart.ui.screens.home

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel: ViewModel(){
    // Default Value
    val optionsNavBtn: List<String> = listOf("Restaurants", "Deals", "Track Order")

    // Private mutable state
    val _searchValue = MutableStateFlow("")
    val _navActiveBtnIndex = MutableStateFlow(0)

    // Public immutable state
    val searchValue = _searchValue.asStateFlow()
    val navActiveBtnIndex = _navActiveBtnIndex.asStateFlow()

    // Events
    fun onSearchValueChange( text: String){
        _searchValue.value = text
    }
    fun onNavBtnClick(index: Int) {
        _navActiveBtnIndex.value = index
    }
}