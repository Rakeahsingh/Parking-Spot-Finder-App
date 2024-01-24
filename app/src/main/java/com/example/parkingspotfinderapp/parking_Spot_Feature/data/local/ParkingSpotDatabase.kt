package com.example.parkingspotfinderapp.parking_Spot_Feature.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.parkingspotfinderapp.parking_Spot_Feature.data.local.entity.ParkingSpotEntity


@Database(
    entities = [ParkingSpotEntity::class],
    version = 1,
    exportSchema = false
)
abstract class ParkingSpotDatabase: RoomDatabase() {

    abstract val dao: ParkingSpotDao

}