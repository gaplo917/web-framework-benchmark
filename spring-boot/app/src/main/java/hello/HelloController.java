package hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@RestController
public class HelloController {
    
    @RequestMapping("/")
    public String index() {
        return "OK";
    }

    @RequestMapping("/2ms")
    public String index2ms() throws InterruptedException {
	Thread.sleep(2);
        return "OK";
    }
    @RequestMapping("/5ms")
    public String index5ms() throws InterruptedException {
        Thread.sleep(5);
        return "OK";
    }

    @RequestMapping("/10ms")
    public String index10ms() throws InterruptedException {
        Thread.sleep(10);
        return "OK";
    }

    @RequestMapping("/future")
    public Future<String> indexF() {
        return CompletableFuture.completedFuture("OK");
    }

    @RequestMapping("/future2ms")
    public Future<String> indexF2ms() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2);
                return "OK";
            } catch (InterruptedException e) {
                throw new IllegalStateException("should not throw");
            }
        });
    }
    
    @RequestMapping("/future5ms")
    public Future<String> indexF5ms() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5);
                return "OK";
            } catch (InterruptedException e) {
                throw new IllegalStateException("should not throw");
            }
        });
    }

    @RequestMapping("/future10ms")
    public Future<String> indexF10ms() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(10);
                return "OK";
            } catch (InterruptedException e) {
                throw new IllegalStateException("should not throw");
            }
        });
    }
}
