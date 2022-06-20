package com.example.wb_week_7_3.model.dataSource.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FavoriteEntity(
    @PrimaryKey
    var id: String = "",
    var imageUrl: String = "",
)
