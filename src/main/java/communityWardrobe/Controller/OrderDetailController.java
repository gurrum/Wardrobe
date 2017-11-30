package communityWardrobe.Controller;

import communityWardrobe.Controller.model.NGORegistrationDTO;
import communityWardrobe.Controller.model.OrderDTO;
import communityWardrobe.tiacloud.service.OrderDetailService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class OrderDetailController {

  OrderDetailService orderDetailService;

  @RequestMapping(value = "/orderDetails", method = RequestMethod.POST)
  public ResponseEntity createOrder(@RequestBody OrderDTO orderDTO){

    orderDetailService.createOrder(orderDTO);
    HttpHeaders headers = new HttpHeaders();
    return new ResponseEntity<>(headers, HttpStatus.ACCEPTED);
  }

  @RequestMapping(value = "/orderDetails/{orderId}", method = RequestMethod.GET)
  @ResponseBody
  public ResponseEntity<OrderDTO> getOrder(@PathVariable Integer orderId){
    OrderDTO response = orderDetailService.getOrder(orderId);
    HttpHeaders headers = new HttpHeaders();
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
