package com.example.parkingspotfinderapp.parking_Spot_Feature.presentation.parkingSpotScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parkingspotfinderapp.parking_Spot_Feature.domain.model.ParkingSpotModel
import com.example.parkingspotfinderapp.parking_Spot_Feature.domain.use_Case.ParkingSpotUseCase
import com.example.parkingspotfinderapp.parking_Spot_Feature.presentation.parkingSpotScreen.component.ParkingSpotEvent
import com.example.parkingspotfinderapp.parking_Spot_Feature.presentation.parkingSpotScreen.component.ParkingSpotState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ParkingSpotMapViewModel @Inject constructor(
    private val useCase: ParkingSpotUseCase
): ViewModel() {

    private val _state = MutableStateFlow(ParkingSpotState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            getParkingSpots()
        }
    }

    fun onEvent(event: ParkingSpotEvent){
        when(event){
            is ParkingSpotEvent.AddMarker -> {
                viewModelScope.launch {
                    useCase.addParkingSpotUseCase.invoke(
                        ParkingSpotModel(
                            latitude = event.latLng.latitude,
                            longitude = event.latLng.longitude
                        )
                    )
                }
            }

            is ParkingSpotEvent.DeleteMarker -> {
                viewModelScope.launch {
                    useCase.deleteParkingSpotUseCase.invoke(
                        event.parkingSpot
                    )
                }
            }

            is ParkingSpotEvent.LoadMap -> {
                Timber.tag("Loading").i("onEvent: loaded")
            }

        }
    }

    private suspend fun getParkingSpots(){
        useCase.getAllParkingSpotUseCase.invoke()
            .collectLatest { spots ->
                Timber.i("size is" + spots.size)
                _state.update {
                    it.copy(
                        parkingSpot = spots
                    )
                }
            }
    }

}