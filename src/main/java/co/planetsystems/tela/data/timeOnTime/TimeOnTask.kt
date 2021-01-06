package co.planetsystems.tela.data.timeOnTime

import android.text.format.Time
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
        tableName = TimeOnTaskNames.TABLE_NAME
)
data class TimeOnTask(
        @ColumnInfo(name = TimeOnTaskNames.DATE_CREATED)
        var dateCreated: String,

        @ColumnInfo(name = TimeOnTaskNames.DATE_UPDATED)
        var dateUpdated: String,

        @ColumnInfo(name = TimeOnTaskNames.STATUS)
        var status: String,

        @ColumnInfo(name = TimeOnTaskNames.ACTION_STATUS)
        var actionStatus: String,

        @ColumnInfo(name = TimeOnTaskNames.COMMENT)
        var comment: String,

        @ColumnInfo(name = TimeOnTaskNames.EMPLOYEE_ID)
        var employeeId: String,

        @ColumnInfo(name = TimeOnTaskNames.EMPLOYEE_NO)
        var employeeNo: String,

        @ColumnInfo(name = TimeOnTaskNames.TASK_ID)
        var taskId: String,

        @ColumnInfo(name = TimeOnTaskNames.TRANSACTION_DATE)
        var transactionDate: String,

        @ColumnInfo(name = TimeOnTaskNames.TRANSACTION_TIME)
        var transactionTime: String,

        @ColumnInfo(name = TimeOnTaskNames.SUPERVISION_STATUS)
        var supervisionStatus: String,

        @ColumnInfo(name = TimeOnTaskNames.IN_TIME)
        var inTime: String,

        @ColumnInfo(name = TimeOnTaskNames.SUPERVISION_ID)
        var supervisionId: String,

        @ColumnInfo(name = TimeOnTaskNames.FIRST_NAME)
        var firstName: String,

        @ColumnInfo(name = TimeOnTaskNames.LAST_NAME)
        var lastName: String,

        @ColumnInfo(name = TimeOnTaskNames.END_TIME)
        var endTime: String,

        @ColumnInfo(name = TimeOnTaskNames.START_TIME)
        var startTime: String,

        @ColumnInfo(name = TimeOnTaskNames.TASK_NAME)
        var taskName: String,

        @ColumnInfo(name = TimeOnTaskNames.IS_UPLOADED)
        var isUploaded: Boolean
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = TimeOnTaskNames.PRIMARY_KEY)
    var id: Int = 0
}