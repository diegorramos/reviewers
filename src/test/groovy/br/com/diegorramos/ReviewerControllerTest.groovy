package br.com.diegorramos

import io.micronaut.http.HttpRequest
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MicronautTest
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest
class ReviewerControllerTest extends Specification {

    @Inject
    @Client('/reviewers')
    RxHttpClient rxHttpClient
    String body

    void setup() {
        body = """
                {
                  "action": "opened",
                  "issue": {
                    "url": "https://api.github.com/repos/octocat/Hello-World/issues/1347",
                    "number": 1347
                  },
                  "repository" : {
                    "id": 1296269,
                    "full_name": "octocat/Hello-World",
                    "owner": {
                      "login": "octocat",
                      "id": 1
                    }
                  },
                  "sender": {
                    "login": "octocat",
                    "id": 1
                  }
                }
            """
    }

    def "should receive event and return string"() {
        when:
            def response = rxHttpClient.toBlocking().retrieve(HttpRequest.POST('/', body), String)
        then:
            response == 'created'
    }
}
