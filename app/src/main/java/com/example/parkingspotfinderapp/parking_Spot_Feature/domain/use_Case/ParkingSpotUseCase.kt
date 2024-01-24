package com.example.parkingspotfinderapp.parking_Spot_Feature.domain.use_Case

data class ParkingSpotUseCase(
    val addParkingSpotUseCase: AddParkingSpotUseCase,
    val deleteParkingSpotUseCase: DeleteParkingSpotUseCase,
    val getAllParkingSpotUseCase: GetAllParkingSpotUseCase
)
