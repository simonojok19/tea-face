package co.planetsystems.tela.data.role

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
        tableName = RoleNames.TABLE_NAME
)
data class Role(
        @ColumnInfo(name = RoleNames.DATE_CREATED)
        var dateCreated: String,

        @ColumnInfo(name = RoleNames.DATE_UPDATED)
        var dateUpdated: String,

        @ColumnInfo(name = RoleNames.DESCRIPTION)
        var description: String,

        @ColumnInfo(name = RoleNames.EMPLOYEE_ROLE)
        var employeeRole: String,

        @ColumnInfo(name = RoleNames.STATUS)
        var status: String,

        @ColumnInfo(name = RoleNames.IS_UPLOADED)
        var isUploaded: Boolean
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = RoleNames.PRIMARY_KEY)
    var id: Int = 0
}