package co.planetsystems.tela.data.clock_out

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface ClockOutDao {
    @Insert
    fun insertClockOut(clockOut: ClockOut)
}