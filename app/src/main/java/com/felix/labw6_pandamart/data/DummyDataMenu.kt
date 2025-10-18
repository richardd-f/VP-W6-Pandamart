package com.felix.labw6_pandamart.data

import com.felix.labw6_pandamart.R
import com.felix.labw6_pandamart.model.MenuModel

class DummyDataMenu {
    val PopularMenu: List<MenuModel> = listOf(
        MenuModel("Zinger Burger", 2, R.drawable.burger),
        MenuModel("Roll Paratha", 3, R.drawable.roll_paratha),
        MenuModel("Tomatto Soup", 2, R.drawable.tomato_soup),
        MenuModel("Long Burger", 5, R.drawable.long_burger),
        MenuModel("Creamy Biscuit", 5, R.drawable.creamy_biscuit),
        MenuModel("Ice Paratha", 3, R.drawable.ice_paratha),
    )

    val FeaturedProduct: List<MenuModel> = listOf(
        MenuModel("Fresh Peach", 9, R.drawable.peach),
        MenuModel("Avocado", 7, R.drawable.avocado),
        MenuModel("Pineapple", 5, R.drawable.pineapple),
        MenuModel("Fresh Brocoli", 3, R.drawable.brocolli),
    )
}