package co.planetsystems.tela.common

val CONFIGURATION: Configuration = DebugConfiguration

object ProductionConfiguration: Configuration {
    override val SPLASH_SCREEN_DURATION: Long
        get() = 5000
}

object DebugConfiguration: Configuration {
    override val SPLASH_SCREEN_DURATION: Long
        get() = 1000

}

interface Configuration {
    val SPLASH_SCREEN_DURATION: Long
}