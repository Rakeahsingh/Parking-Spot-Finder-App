package com.example.parkingspotfinderapp.parking_Spot_Feature.presentation.parkingSpotScreen.component

import com.example.parkingspotfinderapp.core.mapStyle.MapStyle
import com.example.parkingspotfinderapp.parking_Spot_Feature.domain.model.ParkingSpotModel
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapUiSettings

data class ParkingSpotState(

    val mapProperties: MapProperties = MapProperties(
        mapStyleOptions = MapStyleOptions(MapStyle.STYLE_JSON)
    ),
    val defaultCameraState: CameraPositionState = CameraPositionState(
        position = CameraPosition.fromLatLngZoom(
            LatLng(1.35, 103.87),
            1f
        )
    ),
    val uiSetting: MapUiSettings = MapUiSettings(),
    val parkingSpot: List<ParkingSpotModel> = emptyList()

)
