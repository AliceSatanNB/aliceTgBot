package ru.greyTechGoo

import io.github.dehuckakpyt.telegrambot.config.TelegramBotConfig
import io.github.dehuckakpyt.telegrambot.ext.config.receiver.handling
import io.github.dehuckakpyt.telegrambot.factory.TelegramBotFactory
import ru.greyTechGoo.handler.startCommand
import ru.greyTechGoo.handler.helpCommand
import io.github.cdimascio.dotenv.Dotenv


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main(args: Array<String>): Unit {
    var dotenv = Dotenv.configure().load()
    val config = TelegramBotConfig().apply {
        token = dotenv.get("TELEGRAM_TOKEN")
        username = dotenv.get("TELEGRAM_USERNAME")
        receiving {
            handling {
                startCommand()
                helpCommand()
            }
        }
    }

    val context = TelegramBotFactory.createTelegramBotContext(config)
    val updateReceiver = context.updateReceiver
    updateReceiver.start()
    readlnOrNull()
    updateReceiver.stop()
}