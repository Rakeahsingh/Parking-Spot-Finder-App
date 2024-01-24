package com.example.parkingspotfinderapp.parking_Spot_Feature.domain.use_Case

import com.example.parkingspotfinderapp.parking_Spot_Feature.domain.model.ParkingSpotModel
import com.example.parkingspotfinderapp.parking_Spot_Feature.domain.repository.ParkingSpotRepository
import javax.inject.Inject

class DeleteParkingSpotUseCase @Inject constructor(
    private val repository: ParkingSpotRepository
){

    suspend operator fun invoke(parkingSpot: ParkingSpotModel){
        repository.deleteParkingSpot(parkingSpot)
    }

}