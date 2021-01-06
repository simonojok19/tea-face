package co.planetsystems.tela.data.timeOnTask

import androidx.room.Dao

@Dao
interface TimeOnTaskDao {
    fun insertTimeOnTask(timeOnTask: TimeOnTask)
}