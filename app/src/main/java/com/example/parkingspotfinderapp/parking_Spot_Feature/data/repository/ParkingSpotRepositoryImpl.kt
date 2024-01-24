package com.example.parkingspotfinderapp.parking_Spot_Feature.data.repository

import com.example.parkingspotfinderapp.parking_Spot_Feature.data.local.ParkingSpotDao
import com.example.parkingspotfinderapp.parking_Spot_Feature.data.mapper.toParkingSpotEntity
import com.example.parkingspotfinderapp.parking_Spot_Feature.data.mapper.toParkingSpotModel
import com.example.parkingspotfinderapp.parking_Spot_Feature.domain.model.ParkingSpotModel
import com.example.parkingspotfinderapp.parking_Spot_Feature.domain.repository.ParkingSpotRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class ParkingSpotRepositoryImpl(
    private val dao: ParkingSpotDao
): ParkingSpotRepository {
    override suspend fun insertParkingSpot(parkingSpot: ParkingSpotModel) {
        dao.insertParkingSot(parkingSpot.toParkingSpotEntity())
    }

    override suspend fun deleteParkingSpot(parkingSpot: ParkingSpotModel) {
        dao.deleteParkingSpot(parkingSpot.toParkingSpotEntity())
    }

    override fun getAllParkingSpot(): Flow<List<ParkingSpotModel>> {
        return flow {
            dao.getAllParkingSpot().map { parkingSpot ->
                parkingSpot.map {
                    it.toParkingSpotModel()
                }
            }
        }
    }
}