package co.planetsystems.tela.data.role

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface RoleDao {
    @Insert
    fun insertRole(role: Role)
}