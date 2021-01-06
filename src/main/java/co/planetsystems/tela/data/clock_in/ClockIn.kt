package co.planetsystems.tela.data.clock_in

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
        tableName = ClockInNames.TABLE_NAME
)
data class ClockIn(
        @ColumnInfo(name = ClockInNames.EMPLOYEE_NUMBER)
        var employeeNumber: String,

        @ColumnInfo(name = ClockInNames.EMPLOYEE_ID)
        var employeeId: String,

        @ColumnInfo(name = ClockInNames.FIRST_NAME)
        var firstName: String,

        @ColumnInfo(name = ClockInNames.LAST_NAME)
        var lastName: String,

        @ColumnInfo(name = ClockInNames.LATITUDE)
        var latitude: String,

        @ColumnInfo(name = ClockInNames.LONGITUDE)
        var longitute: String,

        @ColumnInfo(name = ClockInNames.DATE)
        var date: String,

        @ColumnInfo(name = ClockInNames.TIME)
        var time: String,

        @ColumnInfo(name = ClockInNames.SCHOOL_ID)
        var schoolId: String,

        @ColumnInfo(
                name = ClockInNames.FACE_PRINT,
                typeAffinity = ColumnInfo.BLOB
        )
        var facePrint: ByteArray,

        @ColumnInfo(
                name = ClockInNames.FINGER_PRINT
        )
        var fingerPrint: ByteArray,

        @ColumnInfo(name = ClockInNames.IS_UPLOADED)
        var isUploaded: Boolean
) {
    @ColumnInfo(name = ClockInNames.PRIMARY_KEY)
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ClockIn

        if (employeeNumber != other.employeeNumber) return false
        if (employeeId != other.employeeId) return false
        if (firstName != other.firstName) return false
        if (lastName != other.lastName) return false
        if (latitude != other.latitude) return false
        if (longitute != other.longitute) return false
        if (date != other.date) return false
        if (time != other.time) return false
        if (schoolId != other.schoolId) return false
        if (!facePrint.contentEquals(other.facePrint)) return false
        if (!fingerPrint.contentEquals(other.fingerPrint)) return false
        if (isUploaded != other.isUploaded) return false
        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        var result = employeeNumber.hashCode()
        result = 31 * result + employeeId.hashCode()
        result = 31 * result + firstName.hashCode()
        result = 31 * result + lastName.hashCode()
        result = 31 * result + latitude.hashCode()
        result = 31 * result + longitute.hashCode()
        result = 31 * result + date.hashCode()
        result = 31 * result + time.hashCode()
        result = 31 * result + schoolId.hashCode()
        result = 31 * result + facePrint.contentHashCode()
        result = 31 * result + fingerPrint.contentHashCode()
        result = 31 * result + isUploaded.hashCode()
        result = 31 * result + id
        return result
    }
}