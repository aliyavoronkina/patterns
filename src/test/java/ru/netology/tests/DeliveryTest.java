package ru.netology.tests;

import ru.netology.utils.DataGenerator;
import ru.netology.domain.UserInfo;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class DeliveryTest {

    @BeforeEach
    void setup() {
        open("http://localhost:9999");
    }

    @Test
    void shouldSuccessfulPlanAndReplanMeeting() {
        UserInfo user = DataGenerator.generateUser();
        String firstDate = DataGenerator.generateDate(4);
        String secondDate = DataGenerator.generateDate(7);

        // Первая запись
        $("[data-test-id=city] input").setValue(user.getCity());
        $("[data-test-id=date] input")
                .sendKeys(org.openqa.selenium.Keys.chord(
                                org.openqa.selenium.Keys.SHIFT,
                                org.openqa.selenium.Keys.HOME),
                        org.openqa.selenium.Keys.BACK_SPACE);
        $("[data-test-id=date] input").setValue(firstDate);
        $("[data-test-id=name] input").setValue(user.getName());
        $("[data-test-id=phone] input").setValue(user.getPhone());
        $("[data-test-id=agreement]").click();
        $(".button").click();

        // Проверяем первую запись
        $("[data-test-id=success-notification] .notification__content")
                .shouldHave(Condition.text("Встреча успешно запланирована на " + firstDate),
                        Duration.ofSeconds(15));

        // Перепланирование (ТОЛЬКО ЭТО ДОБАВИТЬ)
        $("[data-test-id=date] input")
                .sendKeys(org.openqa.selenium.Keys.chord(
                                org.openqa.selenium.Keys.SHIFT,
                                org.openqa.selenium.Keys.HOME),
                        org.openqa.selenium.Keys.BACK_SPACE);
        $("[data-test-id=date] input").setValue(secondDate);
        $(".button").click();

        // Подтверждаем перепланирование
        $("[data-test-id=replan-notification] .button").click();

        // Проверяем перепланирование
        $("[data-test-id=success-notification] .notification__content")
                .shouldHave(Condition.text("Встреча успешно запланирована на " + secondDate),
                        Duration.ofSeconds(15));
    }
}