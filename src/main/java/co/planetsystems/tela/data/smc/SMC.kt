package co.planetsystems.tela.data.smc

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
        tableName = SMCNames.TABLE_NAME
)
data class SMC(
        @ColumnInfo(name = SMCNames.COMMENT)
        var comment: String,

        @ColumnInfo(name = SMCNames.VISIT_DATE)
        var visitDate: String,

        @ColumnInfo(name = SMCNames.DEPLOYMENT_UNIT_ID)
        var deploymentUnitId: String,

        @ColumnInfo(name = SMCNames.HEAD_TEACHER_PRESENT)
        var headTeacherPresent: String,

        @ColumnInfo(name = SMCNames.PRIMARY_ONE)
        var primaryOne: String,

        @ColumnInfo(name = SMCNames.PRIMARY_TWO)
        var primaryTwo: String,

        @ColumnInfo(name = SMCNames.PRIMARY_THREE)
        var primaryThree: String,

        @ColumnInfo(name = SMCNames.PRIMARY_FOUR)
        var primaryFour: String,

        @ColumnInfo(name = SMCNames.PRIMARY_FIVE)
        var primaryFive: String,

        @ColumnInfo(name = SMCNames.PRIMARY_SIX)
        var primarySix: String,

        @ColumnInfo(name = SMCNames.PRIMARY_SEVEN)
        var primarySeven: String,

        @ColumnInfo(name = SMCNames.SMC_CODE)
        var smcCode: String,

        @ColumnInfo(name = SMCNames.STAFF_NOT_TEACHING)
        var staffNotTeaching: String,

        @ColumnInfo(name = SMCNames.STAFF_PRESENT)
        var staffPresent: String,

        @ColumnInfo(name = SMCNames.STAFF_TEACHER)
        var staffTeaching: String,

        @ColumnInfo(name = SMCNames.IS_UPLOADED)
        var isUploaded: Boolean
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = SMCNames.PRIMARY_KEY)
    var id: Int = 0
}