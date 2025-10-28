# Автотесты для доставки карты

![Java](https://img.shields.io/badge/Java-17-red)
![Selenide](https://img.shields.io/badge/Selenide-6.17.2-blue)
![JUnit5](https://img.shields.io/badge/JUnit5-5.9.2-green)
![Gradle](https://img.shields.io/badge/Gradle-7.4-yellow)
![GitHub Actions](https://github.com/aliyavoronkina/patterns/actions/workflows/gradle.yml/badge.svg)  ✅ БЕЙДЖ CI

## Запуск тестов

```bash
# Обычный запуск (видно браузер)
./gradlew test

# Headless режим (для CI)
./gradlew test -Dselenide.headless=true