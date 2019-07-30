package com.jungle.weather.collection.eureka;

        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class WeatherCollectionEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherCollectionEurekaApplication.class, args);
    }

}
