package co.planetsystems.tela.data.attendance

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
        tableName = AttendanceNames.TABLE_NAME
)
data class Attendance(
        @ColumnInfo(name = AttendanceNames.DATE_CREATED)
        var dateCreated: String,

        @ColumnInfo(name = AttendanceNames.DATE_UPDATED)
        var dateUpdated: String,

        @ColumnInfo(name = AttendanceNames.STATUS)
        var status: String,

        @ColumnInfo(name = AttendanceNames.COMMENT)
        var comment: String,

        @ColumnInfo(name = AttendanceNames.DEPLOYMENT_UNIT)
        var deploymentUnit: String,

        @ColumnInfo(name = AttendanceNames.DEPLOYMENT_UNIT_ID)
        var deploymentUnitId: String,

        @ColumnInfo(name = AttendanceNames.FEMALE_ABSENT)
        var femaleAbsent: Int,

        @ColumnInfo(name = AttendanceNames.MALE_ABSENT)
        var maleAbsent: Int,

        @ColumnInfo(name = AttendanceNames.MALE_PRESENT)
        var malePresent: Int,

        @ColumnInfo(name = AttendanceNames.SUBMISSION_DATE)
        var submissionDate: String,

        @ColumnInfo(name = AttendanceNames.SUPERVISOR_ID)
        var supervisorId: String,

        @ColumnInfo(name = AttendanceNames.TASK_DAY)
        var taskDay: String,

        @ColumnInfo(name = AttendanceNames.STORED_LOCALLY)
        var storeLocally: Boolean
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}