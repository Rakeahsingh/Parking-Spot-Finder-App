package com.example.parkingspotfinderapp.di

import android.app.Application
import androidx.room.Room
import com.example.parkingspotfinderapp.parking_Spot_Feature.data.local.ParkingSpotDatabase
import com.example.parkingspotfinderapp.parking_Spot_Feature.data.repository.ParkingSpotRepositoryImpl
import com.example.parkingspotfinderapp.parking_Spot_Feature.domain.repository.ParkingSpotRepository
import com.example.parkingspotfinderapp.parking_Spot_Feature.domain.use_Case.AddParkingSpotUseCase
import com.example.parkingspotfinderapp.parking_Spot_Feature.domain.use_Case.DeleteParkingSpotUseCase
import com.example.parkingspotfinderapp.parking_Spot_Feature.domain.use_Case.GetAllParkingSpotUseCase
import com.example.parkingspotfinderapp.parking_Spot_Feature.domain.use_Case.ParkingSpotUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application): ParkingSpotDatabase{
        return Room.databaseBuilder(
            app,
            ParkingSpotDatabase::class.java,
            "parkingSpot_db"
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideRepository(db: ParkingSpotDatabase): ParkingSpotRepository{
        return ParkingSpotRepositoryImpl(db.dao)
    }

    @Provides
    @Singleton
    fun provideUseCase(repository: ParkingSpotRepository): ParkingSpotUseCase{
        return ParkingSpotUseCase(
            addParkingSpotUseCase = AddParkingSpotUseCase(repository),
            deleteParkingSpotUseCase = DeleteParkingSpotUseCase(repository),
            getAllParkingSpotUseCase = GetAllParkingSpotUseCase(repository)
        )
    }

}