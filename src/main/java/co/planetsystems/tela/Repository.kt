package co.planetsystems.tela

import android.app.Application
import android.content.Context
import androidx.room.Room
import co.planetsystems.tela.data.TelaDatabase
import co.planetsystems.tela.data.teacher.Teacher
import java.util.concurrent.Callable
import java.util.concurrent.Executors

class Repository(context: Context) {
    val telaDatabase = TelaDatabase.getInstance(context)


    fun enrollTeacher(teacher: Teacher) {
        TelaDatabase.EXECUTOR.execute(Runnable {
            telaDatabase.teacherDao().enrollTeacher(teacher)
        })
    }

    fun getTeacherByNationalID(nationalID: String): Teacher? {
        val callable = Callable<Teacher>() {
            telaDatabase.teacherDao().getTeacherByNationalID(nationalID)
        }
        return TelaDatabase.EXECUTOR.submit(callable).get()
    }

    fun updateTeacher(teacher: Teacher) {
        TelaDatabase.EXECUTOR.execute {
            telaDatabase.teacherDao().updateTeacher(teacher)
        }
    }

    fun getTeachers(): List<Teacher>? {
        val callable = Callable {
            telaDatabase.teacherDao().getTeachers()
        }
        return TelaDatabase.EXECUTOR.submit(callable).get()
    }


    companion object {
        @Volatile
        private var INSTANCE: Repository? = null
        fun getInstance(context: Context): Repository {
            return INSTANCE ?: synchronized(this) {
                val instance = Repository(context.applicationContext)
                INSTANCE = instance
                instance
            }
        }
        val EXECUTOR = Executors.newFixedThreadPool(4)
    }
}