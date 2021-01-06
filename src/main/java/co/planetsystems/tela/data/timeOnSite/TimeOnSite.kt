package co.planetsystems.tela.data.timeOnSite

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
        tableName = TimeOnSiteNames.TABLE_NAME
)
data class TimeOnSite(
        @ColumnInfo(name = TimeOnSiteNames.DATE_CREATED)
        var dateCreated: String,

        @ColumnInfo(name = TimeOnSiteNames.DATE_UPLOADED)
        var dateUpdated: String,

        @ColumnInfo(name = TimeOnSiteNames.STATUS)
        var status: String,

        @ColumnInfo(name = TimeOnSiteNames.EMPLOYEE_ID)
        var employeeId: String,

        @ColumnInfo(name = TimeOnSiteNames.EMPLOYEE_NO)
        var employeeNo: String,

        @ColumnInfo(name = TimeOnSiteNames.SUPERVISION_DATE)
        var supervisionDate: String,

        @ColumnInfo(name = TimeOnSiteNames.SUPERVISION_STATUS)
        var supervisionStatus: String,

        @ColumnInfo(name = TimeOnSiteNames.SUPERVISION_COMMENT)
        var supervisionComment: String,

        @ColumnInfo(name = TimeOnSiteNames.SUPERVISION_ID)
        var supervisionId: String,

        @ColumnInfo(name = TimeOnSiteNames.IS_UPLOADED)
        var isUploaded: Boolean
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = TimeOnSiteNames.PRIMARY_KEY)
    var id: Int = 0
}