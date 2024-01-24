package com.example.parkingspotfinderapp.parking_Spot_Feature.presentation.parkingSpotScreen.component

import com.example.parkingspotfinderapp.parking_Spot_Feature.domain.model.ParkingSpotModel
import com.google.android.gms.maps.model.LatLng

sealed class ParkingSpotEvent {

    data class AddMarker(val latLng: LatLng): ParkingSpotEvent()
    data class DeleteMarker(val parkingSpot: ParkingSpotModel): ParkingSpotEvent()
    data object LoadMap: ParkingSpotEvent()

}