import com.leopoldhsing.horizon.service.dwolla.config.DwollaConfiguration
import org.junit.jupiter.api.Test

class ConfigurationTest(private val dwollaConfiguration: DwollaConfiguration) {

    @Test
    fun test() {
        println(dwollaConfiguration)
    }

}
