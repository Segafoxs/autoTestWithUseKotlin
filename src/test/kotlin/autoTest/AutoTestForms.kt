package autoTest

import WebHooks
import org.junit.jupiter.api.Test
import page.forms.FormOne
import com.codeborne.selenide.Selenide.open

class AutoTestForms: WebHooks() {
    private val formOne: FormOne = FormOne()

    @Test
    fun testFormOne() {
        formOne.enterForms("Serg", "serg@yandex.ru", "password", "Russia")
    }
}