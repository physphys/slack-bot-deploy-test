package hello

import com.slack.api.bolt.App
import com.slack.api.bolt.jetty.SlackAppServer
import java.lang.Exception

object MyApp {
    @Throws(Exception::class)
    @JvmStatic
    fun main(args: Array<String>) {
        // SLACK_BOT_TOKEN, SLACK_SIGNING_SECRET という環境変数が設定されている前提
        val app = App()
        app.command("/hello") { req, ctx -> ctx.ack(":candy: はい、アメちゃん！") }
        val server = SlackAppServer(app)
        server.start() // http://localhost:3000/slack/events
    }
}