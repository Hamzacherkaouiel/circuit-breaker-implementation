package order.order_microservice.Services;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import order.order_microservice.DTO.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ServiceUser {
    @Autowired
    @Lazy
    private RestTemplate restTemplate;

    public static final String USER_SERVICE="userService";

    private static final String BASEURL = "http://localhost:9091/orders";

    @CircuitBreaker(name =USER_SERVICE,fallbackMethod = "getAllAvailableProducts")
    public List<OrderDTO> fetchOrders(String category){

        String url= category==null ? BASEURL:BASEURL+"/"+category;
        return restTemplate.getForObject(url, ArrayList.class);
    }

    public List<OrderDTO> getAllAvailableProducts(String category,Exception e){
        return Stream.of(
                new OrderDTO(119, "LED TV", "electronics", "white", 45000),
                new OrderDTO(345, "Headset", "electronics", "black", 7000),
                new OrderDTO(475, "Sound bar", "electronics", "black", 13000),
                new OrderDTO(574, "Puma Shoes", "foot wear", "black & white", 4600),
                new OrderDTO(678, "Vegetable chopper", "kitchen", "blue", 999),
                new OrderDTO(532, "Oven Gloves", "kitchen", "gray", 745)
        ).collect(Collectors.toList());
    }




    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
