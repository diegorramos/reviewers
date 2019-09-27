package br.com.diegorramos

import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.reactivex.Maybe
import org.slf4j.LoggerFactory

@Controller("/reviewers")
class ReviewerController {

    private val log = LoggerFactory.getLogger(ReviewerController::class.java)

    @Post("/")
    fun event(@Body event: String): Maybe<String> {
        log.info("receive event, payload={}", event)

        return Maybe.just("created")
    }
}