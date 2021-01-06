package co.planetsystems.tela.data.timeTable

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
        tableName = TimeTableNames.TABLE_NAME
)
data class TimeTable(
        @ColumnInfo(name = TimeTableNames.DATE_CREATED)
        var dateCreated: String,

        @ColumnInfo(name = TimeTableNames.DATE_UPDATED)
        var dateUploaded: String,

        @ColumnInfo(name = TimeTableNames.STATUS)
        var status: String,

        @ColumnInfo(name = TimeTableNames.CLASS_ID)
        var classId: String,

        @ColumnInfo(name = TimeTableNames.CLASS_UNIT)
        var classUnit: String,

        @ColumnInfo(name = TimeTableNames.DAY)
        var day: String,

        @ColumnInfo(name = TimeTableNames.EMPLOYEE_NAME)
        var employeeName: String,

        @ColumnInfo(name = TimeTableNames.EMPLOYEE_ID)
        var employeeId: String,

        @ColumnInfo(name = TimeTableNames.EMPLOYEE_NO)
        var employeeNo: String,

        @ColumnInfo(name = TimeTableNames.END_TIME)
        var endTime: String,

        @ColumnInfo(name = TimeTableNames.SCHOOL_ID)
        var schoolId: String,

        @ColumnInfo(name = TimeTableNames.SCHOOL_NAME)
        var schoolName: String,

        @ColumnInfo(name = TimeTableNames.START_TIME)
        var startTime: String,

        @ColumnInfo(name = TimeTableNames.SUBJECT)
        var subject: String,

        @ColumnInfo(name = TimeTableNames.SUBJECT_ID)
        var subjectId: String,

        @ColumnInfo(name = TimeTableNames.TASK_ID)
        var taskId: String,

        @ColumnInfo(name = TimeTableNames.TASK_NAME)
        var taskName: String,

        @ColumnInfo(name = TimeTableNames.CONFIRMATION_STATUS)
        var confirmationStatus: String,

        @ColumnInfo(name = TimeTableNames.IS_UPLOADED)
        var isUploaded: Boolean
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = TimeTableNames.PRIMARY_KEY)
    var id: Int = 0
}