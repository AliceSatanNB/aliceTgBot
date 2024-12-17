plugins {
    kotlin("jvm") version "2.0.0"
}

group = "ru.greyTechGoo"
version = "1.0-SNAPSHOT"
var telegram_bot_version = "0.11.5"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("io.github.dehuckakpyt.telegrambot:telegram-bot-core:$telegram_bot_version")
}

tasks.test {
    useJUnitPlatform()
}