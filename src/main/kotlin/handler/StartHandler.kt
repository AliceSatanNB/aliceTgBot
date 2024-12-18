package ru.greyTechGoo.handler

import io.github.dehuckakpyt.telegrambot.ext.container.chatId
import io.github.dehuckakpyt.telegrambot.factory.keyboard.inlineKeyboard
import io.github.dehuckakpyt.telegrambot.factory.keyboard.replyKeyboard
import io.github.dehuckakpyt.telegrambot.handling.BotHandling
import io.github.dehuckakpyt.telegrambot.model.telegram.KeyboardButton

fun BotHandling.startCommand() {
    command("/start", next = "get_name") {
        sendMessage("Hello, my name is ${bot.username} :-)")
        bot.sendMessage(chatId, "And what is your name?")
    }

    step("get_name", next = "help") {
        sendMessage("Nice to meet you, $text!", replyMarkup = replyKeyboard(
            button = KeyboardButton (text = "HELP!"),
        ))
    }

    step("help", next = "help") {
        if (text == "HELP!") {
            sendMessage("No one will help you...")
        }
    }
}
