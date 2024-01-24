package com.example.parkingspotfinderapp.parking_Spot_Feature.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.parkingspotfinderapp.parking_Spot_Feature.data.local.entity.ParkingSpotEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface ParkingSpotDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertParkingSot(parkingSpotEntity: ParkingSpotEntity)

    @Query("select * from parkingspotentity")
    fun getAllParkingSpot(): Flow<List<ParkingSpotEntity>>

    @Delete
    suspend fun deleteParkingSpot(parkingSpotEntity: ParkingSpotEntity)

}