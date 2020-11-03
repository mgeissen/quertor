package de.matzemedia

import io.ktor.application.*
import io.ktor.html.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import kotlinx.html.*

fun Route.login() {
    get("/login") {

        call.respondHtml {
            head {
                title("Login")
            }
            body {
                form(
                    action = "/login",
                    method = FormMethod.post,
                    encType = FormEncType.applicationXWwwFormUrlEncoded
                ) {
                    input(type = InputType.text, name = "username")
                    input(type = InputType.password, name = "password")
                    input(type = InputType.submit) { value = "Login" }
                }
            }
        }
    }

    post("/login") {
        val post = call.receiveParameters()
        if (post["username"]?.isNotBlank() == true) {
            call.respond { post["password"] }
        } else {
            call.respondText { "Get no username" }
        }
    }
}
