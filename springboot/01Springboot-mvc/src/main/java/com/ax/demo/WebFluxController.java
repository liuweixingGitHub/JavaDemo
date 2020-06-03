package com.ax.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class WebFluxController {


    @GetMapping("/1")
    public String mvc() throws InterruptedException {
        log.info("mvc start");
        TimeUnit.SECONDS.sleep(3);
        log.info("mvc end");
        return "mvc";
    }


    @GetMapping("/2")
    public Mono<String> mono() throws InterruptedException {   // 【改】返回类型为Mono<String>

        log.info("mono start");


//      Mono mono=  Mono.just(todostr("mono2"));
        Mono mono = Mono.fromSupplier(() -> todostr("mono3"));
        log.info(mono.toString());
        log.info("mono end");


        return mono;   // 【改】使用Mono.just生成响应式数据
    }


    public String todostr(String string) {

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("string" + string);
        return string;
    }


}
