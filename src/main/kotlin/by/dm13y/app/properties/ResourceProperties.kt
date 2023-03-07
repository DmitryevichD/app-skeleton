package by.dm13y.app.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties("resources.print")
class ResourcePrintProperties {
    /**
     * Defines the count of resource that should be printed at one time
     * @param throttlingLimit = 323
     */
    var throttlingLimit: Int = 2
}
