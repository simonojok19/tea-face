package co.planetsystems.tela.data.clock_in

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface ClockInDao {
    @Insert
    fun insertClockIn(clockIn: ClockIn)
}