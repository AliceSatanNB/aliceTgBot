package ru.greyTechGoo.handler

import io.github.dehuckakpyt.telegrambot.ext.container.chatId
import io.github.dehuckakpyt.telegrambot.handling.BotHandling

fun BotHandling.startCommand() {
    command("/start", next = "get_name") {
        // you don't have to specify a chatId to send messages
        sendMessage("Hello, my name is ${bot.username} :-)")
        // but you can do it
        bot.sendMessage(chatId, "And what is your name?")
    }

    step("get_name") {
        sendMessage("Nice to meet you, $text!")
    }
}