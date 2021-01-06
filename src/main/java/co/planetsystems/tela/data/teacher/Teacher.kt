package co.planetsystems.tela.data.teacher

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey


//@Entity(
//        tableName = TeacherNames.TABLE_NAME,
//        indices = [
//            @Index(value = arrayOf(TeacherNames.NATIONAL_ID), unique = true)
//        ]
//)
@Entity(
        tableName = TeacherNames.TABLE_NAME,
        indices = [
            Index(
                    value = [
                        TeacherNames.NATIONAL_ID,
                        TeacherNames.EMAIL,
                        TeacherNames.PHONE_NUMBER
                    ],
                unique = true
            )
        ]
)
data class Teacher(
        @ColumnInfo(name = TeacherNames.EMP_NUMBER)
        var employeeNumber: String = "",

        @ColumnInfo(name = TeacherNames.COMP_NUMBER)
        var computerNumber: String = "",

        @ColumnInfo(name = TeacherNames.ROLE)
        var role: String = "Teacher",

        @ColumnInfo(name = TeacherNames.DOD)
        var dob: String = "",

        @ColumnInfo(name = TeacherNames.EMAIL)
        var email: String = "",

        @ColumnInfo(
                name = TeacherNames.FINGER_PRINT,
                typeAffinity = ColumnInfo.BLOB
        )
        var fingerTemplate: ByteArray = byteArrayOf(),

        @ColumnInfo(name = TeacherNames.FIRST_NAME)
        val firstName: String = "",

        @ColumnInfo(name = TeacherNames.LAST_NAME)
        var lastName: String = "",

        @ColumnInfo(name = TeacherNames.GENDER)
        var gender: String = "",

        @ColumnInfo(name = TeacherNames.INITIALS)
        var initial: String = "",

        @ColumnInfo(name = TeacherNames.LICENSED)
        var isLicensed: Boolean = false,

        @ColumnInfo(name = TeacherNames.NATIONAL_ID)
        var nationalId: String = "",

        @ColumnInfo(name = TeacherNames.PHONE_NUMBER)
        var phone: String = "",

        @ColumnInfo(name = TeacherNames.SCHOOL_ID)
        var schoolId: String = "",

        @ColumnInfo(
                name = TeacherNames.OFFLINE
        )
        var isOffline: Boolean = true,

        @ColumnInfo(
                name = TeacherNames.FACE_TEMPLATE,
                typeAffinity = ColumnInfo.BLOB
        )
        var faceTemplate: ByteArray = byteArrayOf(),

        @ColumnInfo(
                name = TeacherNames.FACE_SUBJECT
        )
        var faceSubject: String = ""

) {
    @ColumnInfo(name = TeacherNames.PRIMARY_KEY)
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Teacher

        if (employeeNumber != other.employeeNumber) return false
        if (computerNumber != other.computerNumber) return false
        if (role != other.role) return false
        if (dob != other.dob) return false
        if (email != other.email) return false
        if (!fingerTemplate.contentEquals(other.fingerTemplate)) return false
        if (firstName != other.firstName) return false
        if (lastName != other.lastName) return false
        if (gender != other.gender) return false
        if (initial != other.initial) return false
        if (isLicensed != other.isLicensed) return false
        if (nationalId != other.nationalId) return false
        if (phone != other.phone) return false
        if (schoolId != other.schoolId) return false
        if (isOffline != other.isOffline) return false
        if (!faceTemplate.contentEquals(other.faceTemplate)) return false
        if (faceSubject != other.faceSubject) return false
        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        var result = employeeNumber.hashCode()
        result = 31 * result + computerNumber.hashCode()
        result = 31 * result + role.hashCode()
        result = 31 * result + dob.hashCode()
        result = 31 * result + email.hashCode()
        result = 31 * result + fingerTemplate.contentHashCode()
        result = 31 * result + firstName.hashCode()
        result = 31 * result + lastName.hashCode()
        result = 31 * result + gender.hashCode()
        result = 31 * result + initial.hashCode()
        result = 31 * result + isLicensed.hashCode()
        result = 31 * result + nationalId.hashCode()
        result = 31 * result + phone.hashCode()
        result = 31 * result + schoolId.hashCode()
        result = 31 * result + isOffline.hashCode()
        result = 31 * result + faceTemplate.contentHashCode()
        result = 31 * result + faceSubject.hashCode()
        result = 31 * result + id
        return result
    }
}