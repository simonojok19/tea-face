package co.planetsystems.tela.data.material

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
        tableName = MaterialNames.TABLE_NAME
)
data class Material(
        @ColumnInfo(name = MaterialNames.DATE_CREATED)
        var dateCreated: String,

        @ColumnInfo(name = MaterialNames.DATE_UPDATED)
        var dateUpdated: String,

        @ColumnInfo(name = MaterialNames.STATUS)
        var status: String,

        @ColumnInfo(name = MaterialNames.APPROVED_STATUS)
        var approvedStatus: String,

        @ColumnInfo(name = MaterialNames.CONFIRMATION)
        var confirmation: String,

        @ColumnInfo(name = MaterialNames.COMMENT)
        var comment: String,

        @ColumnInfo(name = MaterialNames.DATE_REQUIRED)
        var dateRequired: String,

        @ColumnInfo(name = MaterialNames.DEPLOYMENT_SITE)
        var deploymentSite: String,

        @ColumnInfo(name = MaterialNames.DEPLOYMENT_SITE_ID)
        var deploymentSiteId: String,

        @ColumnInfo(name = MaterialNames.DEPLOYMENT_UNIT)
        var deploymentUnit: String,

        @ColumnInfo(name = MaterialNames.DEPLOYMENT_UNIT_ID)
        var deploymentUnitId: String,

        @ColumnInfo(name = MaterialNames.EMPLOYEE)
        var employee: String,

        @ColumnInfo(name = MaterialNames.EMPLOYEE_ID)
        var employeeId: String,

        @ColumnInfo(name = MaterialNames.REQUEST_TYPE)
        var requestType: String,

        @ColumnInfo(name = MaterialNames.ITEM_ID)
        var itemId: String,

        @ColumnInfo(name = MaterialNames.ITEM_NAME)
        var itemName: String,

        @ColumnInfo(name = MaterialNames.QUANTITY)
        var quantity: String,

        @ColumnInfo(name = MaterialNames.REQUEST_DATE)
        var requestDate: String,

        @ColumnInfo(name = MaterialNames.APPROVAL)
        var approval: String,

        @ColumnInfo(name = MaterialNames.IS_UPLOADED)
        var isUploaded:Boolean
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = MaterialNames.PRIMARY_KEY)
    var id: Int = 0
}