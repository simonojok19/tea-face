package co.planetsystems.tela.common

val CONFIGURATION: Configuration = DebugConfiguration


object ProductionConfiguration: Configuration {
    override val SPLASH_SCREEN_DURATION: Long
        get() = 5000
    override val LOGIN_URL: String
        get() = "http://tela.planetsystems.co:1001/tela/webapi/attendance/school/0772241709?id=cmd"
}

object DebugConfiguration: Configuration {
    override val SPLASH_SCREEN_DURATION: Long
        get() = 1000
    override val LOGIN_URL: String
        get() = "http://tela.planetsystems.co:1001/tela/webapi/attendance/school/0772241709?id=cmd"

}

interface Configuration {
    val SPLASH_SCREEN_DURATION: Long
    val LOGIN_URL:String
}