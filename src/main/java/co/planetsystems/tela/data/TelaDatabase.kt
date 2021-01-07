package co.planetsystems.tela.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import co.planetsystems.tela.data.attendance.Attendance
import co.planetsystems.tela.data.attendance.AttendanceDao
import co.planetsystems.tela.data.clock_in.ClockIn
import co.planetsystems.tela.data.clock_in.ClockInDao
import co.planetsystems.tela.data.clock_out.ClockOut
import co.planetsystems.tela.data.clock_out.ClockOutDao
import co.planetsystems.tela.data.material.Material
import co.planetsystems.tela.data.material.MaterialDao
import co.planetsystems.tela.data.role.Role
import co.planetsystems.tela.data.role.RoleDao
import co.planetsystems.tela.data.smc.SMC
import co.planetsystems.tela.data.smc.SMCDao
import co.planetsystems.tela.data.teacher.Teacher
import co.planetsystems.tela.data.teacher.TeacherDao
import co.planetsystems.tela.data.timeOnSite.TimeOnSite
import co.planetsystems.tela.data.timeOnSite.TimeOnSiteDao
import co.planetsystems.tela.data.timeOnTask.TimeOnTask
import co.planetsystems.tela.data.timeOnTime.TimeOn
import co.planetsystems.tela.data.timeOnTime.TimeOnDao
import co.planetsystems.tela.data.timeTable.TimeTable
import co.planetsystems.tela.data.timeTable.TimeTableDao
import java.util.concurrent.Executors

@Database(
        entities = arrayOf(
                Teacher::class,
                Attendance::class,
                ClockIn::class,
                ClockOut::class,
                TimeOnSite::class,
                TimeOnTask::class,
                Material::class,
                Role::class,
                TimeTable::class,
                TimeOn::class,
                SMC::class
        ),
        version = 1,
        exportSchema = false
)
abstract class TelaDatabase:  RoomDatabase(){
    abstract fun teacherDao(): TeacherDao
    abstract fun clockInDao(): ClockInDao
    abstract fun attendanceDao(): AttendanceDao
    abstract fun clockOutDao(): ClockOutDao
    abstract fun timeOnSiteDao(): TimeOnSiteDao
    abstract fun materialDao(): MaterialDao
    abstract fun roleDao(): RoleDao
    abstract fun timeTableDao(): TimeTableDao
    abstract fun timeOnDao(): TimeOnDao
    abstract fun SMCDao(): SMCDao

    companion object {
        @Volatile
        private var INSTANCE: TelaDatabase? = null
        fun getInstance(context: Context): TelaDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        TelaDatabase::class.java,
                        "tela_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
        val EXECUTOR = Executors.newFixedThreadPool(4)
    }
}