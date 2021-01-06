package co.planetsystems.tela.data.smc

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface SMCDao {
    @Insert
    fun insertSMC(smc: SMC)
}