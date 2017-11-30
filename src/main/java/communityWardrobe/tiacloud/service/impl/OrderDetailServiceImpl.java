package communityWardrobe.tiacloud.service.impl;

import communityWardrobe.Controller.model.InventoryOrderDetailsDTO;
import communityWardrobe.Controller.model.OrderDTO;
import communityWardrobe.tiacloud.model.entity.OrderDetailEntity;
import communityWardrobe.tiacloud.model.entity.OrderEntity;
import communityWardrobe.tiacloud.repository.OrderDetailRepository;
import communityWardrobe.tiacloud.repository.OrderRepository;
import communityWardrobe.tiacloud.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class OrderDetailServiceImpl implements OrderDetailService {

  @Autowired
  private OrderRepository orderRepository;

  @Autowired
  private OrderDetailRepository orderDetailRepository;


  @Override
  public void createOrder(OrderDTO orderDTO) {
    OrderEntity orderEntity = new OrderEntity();
    orderEntity.setUserName(orderDTO.getUserAddressDTO().getUserName());
    orderEntity.setAddress(orderDTO.getUserAddressDTO().getAddress());
    OrderEntity orderCreated = orderRepository.save(orderEntity);
    List<InventoryOrderDetailsDTO> inventoryOrderDetailsDTOList = orderDTO.getInventoryOrderDetailsDTOList();
    for(InventoryOrderDetailsDTO inventoryOrderDetailsDTO : inventoryOrderDetailsDTOList){
      OrderDetailEntity orderDetailEntity = new OrderDetailEntity();
      orderDetailEntity.setCategory(inventoryOrderDetailsDTO.getCategory());
      orderDetailEntity.setOrderId(orderCreated.getOrderId());
      orderDetailEntity.setQuantity(inventoryOrderDetailsDTO.getQuantity());
      orderDetailEntity.setSize(inventoryOrderDetailsDTO.getSize());
      orderDetailEntity.setType(inventoryOrderDetailsDTO.getType());
      orderDetailRepository.save(orderDetailEntity);

    }








  }
}