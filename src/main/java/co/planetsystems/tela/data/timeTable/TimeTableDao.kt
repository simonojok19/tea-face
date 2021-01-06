package co.planetsystems.tela.data.timeTable

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface TimeTableDao {
    @Insert
    fun insertTimeTable(timeTable: TimeTable)
}