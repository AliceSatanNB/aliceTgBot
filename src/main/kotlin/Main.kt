package ru.greyTechGoo

import io.github.dehuckakpyt.telegrambot.config.TelegramBotConfig
import io.github.dehuckakpyt.telegrambot.ext.config.receiver.handling
import io.github.dehuckakpyt.telegrambot.factory.TelegramBotFactory
import ru.greyTechGoo.handler.startCommand

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main(args: Array<String>): Unit {
    val config = TelegramBotConfig().apply {
        token = System.getenv("TELEGRAM_TOKEN")
        username = System.getenv("TELEGRAM_USERNAME")
        receiving {
            handling {
                startCommand()
            }
        }
    }

    val context = TelegramBotFactory.createTelegramBotContext(config)
    val updateReceiver = context.updateReceiver
    updateReceiver.start()
    readlnOrNull()
    updateReceiver.stop()
}