package com.example.parkingspotfinderapp.parking_Spot_Feature.data.mapper

import com.example.parkingspotfinderapp.parking_Spot_Feature.data.local.entity.ParkingSpotEntity
import com.example.parkingspotfinderapp.parking_Spot_Feature.domain.model.ParkingSpotModel

fun ParkingSpotEntity.toParkingSpotModel(): ParkingSpotModel{
    return ParkingSpotModel(
        id = id,
        latitude = latitude,
        longitude = longitude
    )
}

fun ParkingSpotModel.toParkingSpotEntity(): ParkingSpotEntity{
    return ParkingSpotEntity(
        id = id,
        latitude = latitude,
        longitude = longitude
    )
}