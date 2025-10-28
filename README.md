# Автотесты для доставки карты

![Java](https://img.shields.io/badge/Java-11-red)
![Selenide](https://img.shields.io/badge/Selenide-6.17.2-blue)
![JUnit5](https://img.shields.io/badge/JUnit5-5.9.2-green)
![Gradle](https://img.shields.io/badge/Gradle-8.13-yellow)


## Запуск тестов

```bash
# Локальный запуск (с браузером)
./gradlew test -Dselenide.headless=false

# Запуск в CI (headless режим)
./gradlew test