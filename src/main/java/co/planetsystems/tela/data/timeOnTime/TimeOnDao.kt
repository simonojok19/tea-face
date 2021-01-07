package co.planetsystems.tela.data.timeOnTime

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface TimeOnDao {
    @Insert
    fun insertTimeOnTask(timeOnTask: TimeOn)
}