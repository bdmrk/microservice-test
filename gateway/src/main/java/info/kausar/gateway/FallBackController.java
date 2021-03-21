package info.kausar.gateway;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallBackController {


    @RequestMapping("/orderFallBack")
    public Mono<String> orderServiceFallBack() {
        return Mono.just("Order service is too long to respond or down. Please try later");
    }

    @RequestMapping("/paymentFallBack")
    public Mono<String> paymentServiceFallBack() {
        return Mono.just("Payment service is too long to respond or down. Please try later");
    }
}
