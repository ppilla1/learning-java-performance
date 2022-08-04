package demo;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;

@Log4j2
@RestController
public class WebController {

    private static final int DEFAULT_PORT = 8080;

    @Setter
    private int serverPort = DEFAULT_PORT;

    @GetMapping("/tweets-blocking")
    public List<Tweet> getTweetsBlocking() {
        log.info("Starting BLOCKING Controller!");
        final String uri = getSlowServiceUri();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Tweet>> response = restTemplate.exchange(
                uri, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Tweet>>() {
                });

        List<Tweet> result = response.getBody();
        result.forEach(tweet -> System.out.println(tweet.toString()));
        log.info("Exiting BLOCKING Controller!");
        return result;
    }

    @GetMapping(value = "/tweets-non-blocking", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Tweet> getTweetsNonBlocking() {
        log.info("Starting NON-BLOCKING Controller!");
        Flux<Tweet> tweetFlux = WebClient.create()
                .get()
                .uri(getSlowServiceUri())
                .retrieve()
                .bodyToFlux(Tweet.class)
                .delayElements(Duration.ofSeconds(1))
                .log("Tweets are retrieved : ");

        tweetFlux.subscribe(tweet -> System.out.println(tweet.toString()));

        /*
         * tweetFlux.subscribe(tweet -> System.out.println(tweet.toString()) , err->
         * System.out.println(err) ,()->
         * System.out.println("All data has been recieved") ,sub-> sub.request(1));
         */

        log.info("Exiting NON-BLOCKING Controller!");
        return tweetFlux;
    }


    private String getSlowServiceUri() {
        return "http://localhost:" + serverPort + "/slow-service-tweets";
    }

}
