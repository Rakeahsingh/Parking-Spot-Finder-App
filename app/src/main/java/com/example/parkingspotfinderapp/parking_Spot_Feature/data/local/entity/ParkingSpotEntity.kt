package com.example.parkingspotfinderapp.parking_Spot_Feature.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class ParkingSpotEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val latitude: Double,
    val longitude: Double,
)
