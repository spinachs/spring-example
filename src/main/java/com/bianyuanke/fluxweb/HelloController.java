package com.bianyuanke.fluxweb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

/**
 * @author 马良
 * @since 2019-03-06
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
    @Api
    @GetMapping("/world")
    public Mono<String> world() {
        throw new RequestException(-100, "buxinga");
    }

    @Api
    @GetMapping("/world2")
    public Mono<String> world2(@Valid RequestParam param) {
        return Mono.just("abc");
    }

    @Api
    @GetMapping("/world3")
    public void world3() {
    }
    @GetMapping("/world4")
    public String world4() {

        return "abc";
    }
}