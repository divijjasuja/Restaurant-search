package com.example.restaurantsearcher.data

import com.example.restaurantsearcher.Models.Restaurants
import com.example.restaurantsearcher.R

class DataSource() {
    fun loadRestaurants(): List<Restaurants> {
        return listOf<Restaurants> (
            Restaurants(R.string.chai_point,R.string.chai_point_Description,R.integer.chai_point_cost,R.string.chai_point_rating, R.drawable.chai_point),
            )
    }
}