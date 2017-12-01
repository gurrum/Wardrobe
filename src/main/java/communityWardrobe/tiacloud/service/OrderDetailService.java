package communityWardrobe.tiacloud.service;

import communityWardrobe.Controller.model.OrderDTO;

public interface OrderDetailService {

  void createOrder(OrderDTO orderDTO);

  OrderDTO getOrder(Integer orderId);

  OrderDTO getOrder(String userName);

}
