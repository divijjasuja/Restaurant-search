package com.example.restaurantsearcher.data

import com.example.restaurantsearcher.Models.Restaurants
import com.example.restaurantsearcher.R

class DataSource {
    fun loadRestaurants(): List<Restaurants> {
        return listOf<Restaurants> (
            Restaurants(R.string.chai_point, R.drawable.chai_point),

            )
    }
}