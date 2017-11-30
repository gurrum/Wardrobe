package communityWardrobe.Controller;

import communityWardrobe.Controller.model.OrderDTO;
import communityWardrobe.tiacloud.service.OrderDetailService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class OrderDetailController {

  OrderDetailService orderDetailService;

  @RequestMapping(value = "/orderDetails", method = RequestMethod.POST)
  public ResponseEntity createOrder(@RequestBody OrderDTO orderDTO){

    orderDetailService.createOrder(orderDTO);
    HttpHeaders headers = new HttpHeaders();
    return new ResponseEntity<>(headers, HttpStatus.ACCEPTED);
  }
}
