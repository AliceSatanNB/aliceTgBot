package ru.greyTechGoo.handler

import io.github.dehuckakpyt.telegrambot.handling.BotHandling

fun BotHandling.helpCommand() {

    command("/help") {
        sendMessage("No one will help you...")
    }
}