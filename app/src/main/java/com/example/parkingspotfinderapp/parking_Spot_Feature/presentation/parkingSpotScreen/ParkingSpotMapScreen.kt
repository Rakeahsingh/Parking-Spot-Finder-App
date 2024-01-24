package com.example.parkingspotfinderapp.parking_Spot_Feature.presentation.parkingSpotScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.parkingspotfinderapp.parking_Spot_Feature.presentation.parkingSpotScreen.component.ParkingSpotEvent
import com.example.parkingspotfinderapp.parking_Spot_Feature.presentation.parkingSpotScreen.component.ParkingSpotState
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState

@Composable
fun ParkingSpotScreen(
    state: ParkingSpotState,
    onEvent: (ParkingSpotEvent) -> Unit
) {

    Box(modifier = Modifier.fillMaxSize()){

        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = state.defaultCameraState,
            onMapLoaded = {
                onEvent(ParkingSpotEvent.LoadMap)
            },
            uiSettings = state.uiSetting,
            onMapClick = { position ->
                onEvent(ParkingSpotEvent.AddMarker(position))
            },
            properties = state.mapProperties
        ) {

            state.parkingSpot.forEach { spot ->
                Marker(
                    state = MarkerState(
                        position = LatLng(
                            spot.latitude,
                            spot.longitude
                        )
                    ),
                    alpha = 1f,
                    draggable = false,
                    flat = false,
                    snippet = "long press to delete",
                    tag = "Car",
                    title = "Parking Spot",
                    visible = true,
                    onClick = { marker ->
                        marker.showInfoWindow()
                        true
                    },
                    onInfoWindowLongClick = { marker ->
                        marker.hideInfoWindow()
                        onEvent(ParkingSpotEvent.DeleteMarker(spot))
                    },
                    icon = BitmapDescriptorFactory.defaultMarker(
                        BitmapDescriptorFactory.HUE_AZURE
                    )
                )
            }

        }

    }

}