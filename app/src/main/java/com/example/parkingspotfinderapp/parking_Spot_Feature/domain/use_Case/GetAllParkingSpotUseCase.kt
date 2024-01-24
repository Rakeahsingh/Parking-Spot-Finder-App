package com.example.parkingspotfinderapp.parking_Spot_Feature.domain.use_Case

import com.example.parkingspotfinderapp.parking_Spot_Feature.domain.model.ParkingSpotModel
import com.example.parkingspotfinderapp.parking_Spot_Feature.domain.repository.ParkingSpotRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllParkingSpotUseCase @Inject constructor(
    private val repository: ParkingSpotRepository
){

    operator fun invoke(): Flow<List<ParkingSpotModel>>{
        return repository.getAllParkingSpot()
    }

}