package co.planetsystems.tela.data.material

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface MaterialDao {
    @Insert
    fun insertMaterial(material: Material)
}