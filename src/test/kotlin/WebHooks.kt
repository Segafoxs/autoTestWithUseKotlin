import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide.open
import com.codeborne.selenide.WebDriverRunner
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach


open class WebHooks {
    companion object {
        @JvmStatic
        @BeforeAll
        fun setup() {
            Configuration.baseUrl = "https://aqa-proka4.org/sandbox/web"
            Configuration.browser = "chrome"
            Configuration.headless = false
            Configuration.timeout = 10000
        }
    }

    @BeforeEach
    fun beforeTest(){
        open("https://aqa-proka4.org/sandbox/web")
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }
}