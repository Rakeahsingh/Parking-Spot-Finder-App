package com.example.parkingspotfinderapp.parking_Spot_Feature.domain.repository

import com.example.parkingspotfinderapp.parking_Spot_Feature.domain.model.ParkingSpotModel
import kotlinx.coroutines.flow.Flow

interface ParkingSpotRepository {

    suspend fun insertParkingSpot(parkingSpot: ParkingSpotModel)

    suspend fun deleteParkingSpot(parkingSpot: ParkingSpotModel)

    fun getAllParkingSpot(): Flow<List<ParkingSpotModel>>

}