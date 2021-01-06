package co.planetsystems.tela.data.timeOnTime

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface TimeOnTaskDao {
    @Insert
    fun insertTimeOnTask(timeOnTask: TimeOnTask)
}