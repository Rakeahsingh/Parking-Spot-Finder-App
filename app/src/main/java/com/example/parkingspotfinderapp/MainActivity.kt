package com.example.parkingspotfinderapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.parkingspotfinderapp.parking_Spot_Feature.presentation.parkingSpotScreen.ParkingSpotMapViewModel
import com.example.parkingspotfinderapp.parking_Spot_Feature.presentation.parkingSpotScreen.ParkingSpotScreen
import com.example.parkingspotfinderapp.ui.theme.ParkingSpotFinderAppTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ParkingSpotFinderAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val viewModel = viewModel<ParkingSpotMapViewModel>()
                    val state by viewModel.state.collectAsState()

                    Scaffold(
                        topBar = {
                            CenterAlignedTopAppBar(
                                title = {
                                    Text(
                                        text = "Parking Spot",
                                        color = MaterialTheme.colorScheme.onPrimary
                                    )
                                },
                                colors = TopAppBarDefaults.topAppBarColors(
                                    containerColor = MaterialTheme.colorScheme.primary
                                )
                            )
                        }
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(top = it.calculateTopPadding())
                        ) {
                            ParkingSpotScreen(
                                state = state,
                                onEvent = viewModel::onEvent
                            )
                        }

                    }

                }
            }
        }
    }
}

