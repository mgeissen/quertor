package de.matzemedia

import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

@Suppress("unused") // Referenced in application.conf
fun Application.secondModule() {

    intercept(ApplicationCallPipeline.Call) {
        if (call.request.uri == "/www") {
            call.respondText("I'm the interceptor!'")
        }
    }

    routing {
        get("/wow") {
            call.respondText("WOOOOOOWWWW")
        }
    }

}
