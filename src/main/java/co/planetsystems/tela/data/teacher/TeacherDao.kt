package co.planetsystems.tela.data.teacher

import androidx.room.*

@Dao
interface TeacherDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun enrollTeacher(teacher: Teacher)

    @Query("SELECT * FROM " + TeacherNames.TABLE_NAME + " WHERE " + TeacherNames.NATIONAL_ID + " =:nationalID")
    fun getTeacherByNationalID(nationalID: String): Teacher

    @Update
    fun updateTeacher(teacher: Teacher)

    @Query("SELECT * FROM " + TeacherNames.TABLE_NAME)
    fun getTeachers(): List<Teacher>
}