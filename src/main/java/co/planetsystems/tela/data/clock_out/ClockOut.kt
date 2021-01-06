package co.planetsystems.tela.data.clock_out

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
        tableName = ClockOutNames.TABLE_NAME
)
data class ClockOut(
        @ColumnInfo(name = ClockOutNames.REASON)
        var reason: String,

        @ColumnInfo(name = ClockOutNames.FACE_PRINT)
        var fingerPrint: ByteArray,

        @ColumnInfo(name = ClockOutNames.FACE_PRINT)
        var facePrint: ByteArray,

        @ColumnInfo(name = ClockOutNames.FIRST_NAME)
        var firstName: String,

        @ColumnInfo(name = ClockOutNames.LAST_NAME)
        var lastName: String,

        @ColumnInfo(name = ClockOutNames.SCHOOL_NAME)
        var schoolName: String,

        @ColumnInfo(name = ClockOutNames.SCHOOL_ID)
        var schoolId: String,

        @ColumnInfo(name = ClockOutNames.LONGITUDE)
        var longitude: Double,

        @ColumnInfo(name = ClockOutNames.LATITUDE)
        var latitude: Double,

        @ColumnInfo(name = ClockOutNames.EMPLOYEE_ID)
        var employeeId: String,

        @ColumnInfo(name = ClockOutNames.EMPLOYEE_NUMBER)
        var employeeNumber: String,

        @ColumnInfo(name = ClockOutNames.COMMENT)
        var comment: String,

        @ColumnInfo(name = ClockOutNames.TIME)
        var time: String,

        @ColumnInfo(name = ClockOutNames.DATE)
        var day: String,

        @ColumnInfo(name = ClockOutNames.IS_UPLOADED)
        var isUploaded: Boolean
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ClockOutNames.PRIMARY_KEY)
    var id: Int = 0
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ClockOut

        if (reason != other.reason) return false
        if (!fingerPrint.contentEquals(other.fingerPrint)) return false
        if (!facePrint.contentEquals(other.facePrint)) return false
        if (firstName != other.firstName) return false
        if (lastName != other.lastName) return false
        if (schoolName != other.schoolName) return false
        if (schoolId != other.schoolId) return false
        if (longitude != other.longitude) return false
        if (latitude != other.latitude) return false
        if (employeeId != other.employeeId) return false
        if (employeeNumber != other.employeeNumber) return false
        if (comment != other.comment) return false
        if (time != other.time) return false
        if (day != other.day) return false
        if (isUploaded != other.isUploaded) return false
        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        var result = reason.hashCode()
        result = 31 * result + fingerPrint.contentHashCode()
        result = 31 * result + facePrint.contentHashCode()
        result = 31 * result + firstName.hashCode()
        result = 31 * result + lastName.hashCode()
        result = 31 * result + schoolName.hashCode()
        result = 31 * result + schoolId.hashCode()
        result = 31 * result + longitude.hashCode()
        result = 31 * result + latitude.hashCode()
        result = 31 * result + employeeId.hashCode()
        result = 31 * result + employeeNumber.hashCode()
        result = 31 * result + comment.hashCode()
        result = 31 * result + time.hashCode()
        result = 31 * result + day.hashCode()
        result = 31 * result + isUploaded.hashCode()
        result = 31 * result + id
        return result
    }
}