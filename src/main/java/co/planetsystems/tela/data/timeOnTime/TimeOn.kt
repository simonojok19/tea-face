package co.planetsystems.tela.data.timeOnTime

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
        tableName = TimeOnNames.TABLE_NAME
)
data class TimeOn(
        @ColumnInfo(name = TimeOnNames.DATE_CREATED)
        var dateCreated: String,

        @ColumnInfo(name = TimeOnNames.DATE_UPDATED)
        var dateUpdated: String,

        @ColumnInfo(name = TimeOnNames.STATUS)
        var status: String,

        @ColumnInfo(name = TimeOnNames.ACTION_STATUS)
        var actionStatus: String,

        @ColumnInfo(name = TimeOnNames.COMMENT)
        var comment: String,

        @ColumnInfo(name = TimeOnNames.EMPLOYEE_ID)
        var employeeId: String,

        @ColumnInfo(name = TimeOnNames.EMPLOYEE_NO)
        var employeeNo: String,

        @ColumnInfo(name = TimeOnNames.TASK_ID)
        var taskId: String,

        @ColumnInfo(name = TimeOnNames.TRANSACTION_DATE)
        var transactionDate: String,

        @ColumnInfo(name = TimeOnNames.TRANSACTION_TIME)
        var transactionTime: String,

        @ColumnInfo(name = TimeOnNames.SUPERVISION_STATUS)
        var supervisionStatus: String,

        @ColumnInfo(name = TimeOnNames.IN_TIME)
        var inTime: String,

        @ColumnInfo(name = TimeOnNames.SUPERVISION_ID)
        var supervisionId: String,

        @ColumnInfo(name = TimeOnNames.FIRST_NAME)
        var firstName: String,

        @ColumnInfo(name = TimeOnNames.LAST_NAME)
        var lastName: String,

        @ColumnInfo(name = TimeOnNames.END_TIME)
        var endTime: String,

        @ColumnInfo(name = TimeOnNames.START_TIME)
        var startTime: String,

        @ColumnInfo(name = TimeOnNames.TASK_NAME)
        var taskName: String,

        @ColumnInfo(name = TimeOnNames.IS_UPLOADED)
        var isUploaded: Boolean
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = TimeOnNames.PRIMARY_KEY)
    var id: Int = 0
}