package com.sbigeneral.PINS.config;

import java.time.Duration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Bucket4j;
import io.github.bucket4j.Refill;

@Configuration
public class RateLimitingConfig {

	@Bean
	public Bucket bucket() {
        Bandwidth limit = Bandwidth.classic(5, Refill.intervally(5, Duration.ofMinutes(1)));
        return Bucket4j.builder().addLimit(limit).build();
    }
}


//import io.github.bucket4j.Bandwidth;
//import io.github.bucket4j.Bucket;
//import io.github.bucket4j.Bucket4j;
//import io.github.bucket4j.Refill;
//
//import java.time.Duration;
//
//import org.springframework.context.annotation.Bean;
//
//public class RateLimitingConfig {
//	
//	@Bean
//    public Bucket bucket {
//        Bandwidth limit = Bandwidth.classic(5, Refill.intervally(5, Duration.ofSeconds(5)));
//        Bucket bucket = Bucket4j.builder()
//                                .addLimit(limit)
//                                .build();
//
//        for (int i = 0; i < 10; i++) {
//            if (bucket.tryConsume(1)) {
//                System.out.println("Request " + (i + 1) + ": Allowed");
//                // Simulate API call
//            } else {
//                System.out.println("Request " + (i + 1) + ": Too Many Requests");
//            }
//
//            // Simulate a delay between requests
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}

