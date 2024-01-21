package com.example.busschedule.data

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BusScheduleDao {
    @Query ("SELECT * FROM Schedule ORDER BY arrival_time ASC")
    fun getAll(): Flow<List<BusSchedule>>

    @Query ("SELECT * FROM Schedule WHERE stop_name = :stop_name ORDER BY arrival_time ASC")
    fun getByStopName(stop_name: String): Flow<List<BusSchedule>>
}