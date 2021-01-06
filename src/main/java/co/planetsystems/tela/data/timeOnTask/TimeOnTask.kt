package co.planetsystems.tela.data.timeOnTask

import android.text.format.Time
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
        tableName = TimeOnTaskNames.TABLE_NAME
)
data class TimeOnTask(
        @ColumnInfo(name = TimeOnTaskNames.STATUS)
        var status: String,

        @ColumnInfo(name = TimeOnTaskNames.COMMENT)
        var comment: String,

        @ColumnInfo(name = TimeOnTaskNames.EMPLOYEE_ID)
        var employeeId: String,

        @ColumnInfo(name = TimeOnTaskNames.EMPLOYEE_NUMBER)
        var employeeNumber: String,

        @ColumnInfo(name = TimeOnTaskNames.SUPERVISION_STATUS)
        var supervisionStatus: String,

        @ColumnInfo(name = TimeOnTaskNames.SUPERVISOR_ID)
        var supervisorId: String,

        @ColumnInfo(name = TimeOnTaskNames.TASK_ID)
        var taskId: String,

        @ColumnInfo(name = TimeOnTaskNames.TRANSACTION_DATE)
        var transactionDate: String,

        @ColumnInfo(name = TimeOnTaskNames.IS_UPLOADED)
        var isUploaded: Boolean
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = TimeOnTaskNames.PRIMARY_KEY)
    var id: Int = 0
}