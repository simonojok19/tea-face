package co.planetsystems.tela.data.attendance

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface AttendanceDao {
    @Insert
    fun insertAttendance(attendance: Attendance)
}