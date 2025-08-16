package order.order_microservice.Controller;


import order.order_microservice.DTO.OrderDTO;
import order.order_microservice.Services.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



import java.util.List;

@RestController
@RequestMapping("/user-service")
public class ControllerUser {
    @Autowired
    public ServiceUser serviceUser;



    @GetMapping("/displayOrders")
    public List<OrderDTO> getOrders(@RequestParam("category") String category) {
        return this.serviceUser.fetchOrders(category);
    }






}
