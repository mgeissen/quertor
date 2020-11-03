package de.matzemedia

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

@Suppress("unused") // Referenced in application.conf
fun Application.secondModule() {

    routing {
        get("/wow") {
            call.respondText("WOOOOOOWWWW")
        }
    }

}
