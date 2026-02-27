package page.forms

import com.codeborne.selenide.Condition
import com.codeborne.selenide.SelenideElement
import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.Selenide.`$x`
import java.time.Duration

class FormOne {
    private val userNameField: SelenideElement = `$`("[name='username']").`as`("имя пользователя")
    private val emailField: SelenideElement = `$`("[name='email']").`as`("email")
    private val passwordField: SelenideElement = `$`("[name='password']").`as`("пароль")
    private val countryField: SelenideElement = `$`("[name='country']").`as`("страна проживания")
    private val termsCheckbox: SelenideElement = `$`("[name='terms']").`as`("чекбокс")
    private val submitButton: SelenideElement = `$`("[id='submitBtn']").`as`("кнопка отправки формы")
    private val successText: SelenideElement = `$x`("//div[@id='formResult']//p[contains(@class, 'text-green-800')]")
        .`as`("сообщение об успешной отправке")

    fun enterForms(
        userName: String,
        email: String,
        password: String,
        country: String
    ) {
        enterUserName(userName)
        enterEmail(email)
        enterPassword(password)
        selectCountry(country)
        acceptTerms()
        submitForm()
        verifySuccessMessage()
    }

    private fun enterUserName(userName: String) {
        userNameField.shouldBe(Condition.visible, Duration.ofSeconds(8))
        userNameField.setValue(userName)
    }

    private fun enterEmail(email: String) {
        emailField.shouldBe(Condition.visible, Duration.ofSeconds(8))
        emailField.setValue(email)
    }

    private fun enterPassword(password: String) {
        passwordField.shouldBe(Condition.visible, Duration.ofSeconds(8))
        passwordField.setValue(password)
    }

    private fun selectCountry(country: String) {
        countryField.shouldBe(Condition.visible, Duration.ofSeconds(8))
        countryField.selectOption(country)
    }

    private fun acceptTerms() {
        termsCheckbox.click()
    }

    private fun submitForm() {
        submitButton.click()
    }

    private fun verifySuccessMessage() {
        val messageText = successText.text()
        successText.shouldHave(Condition.text("Форма успешно отправлена!"))
    }
}
