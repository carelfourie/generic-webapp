package genericwebapp.rest;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import reactor.core.publisher.Mono;

@RequestMapping(path = "/test/")
@RestController
public class Test {

    @GetMapping(path = "{id}")
    public Mono<Object> get(@PathVariable("id") UUID uuid) {
        return null;
    }

    @DeleteMapping(path = "{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable("id") String uuid) {
        return null;

        /*return repo
             .findById(tweetId)
             .flatMap(existingTweet ->
                        repo
                            .delete(existingTweet)
                            .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
              )
              .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        */
    }
}
