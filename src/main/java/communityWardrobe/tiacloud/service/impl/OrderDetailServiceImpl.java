package communityWardrobe.tiacloud.service.impl;

import communityWardrobe.Controller.model.*;
import communityWardrobe.tiacloud.model.entity.OrderDetailEntity;
import communityWardrobe.tiacloud.model.entity.OrderEntity;
import communityWardrobe.tiacloud.repository.OrderDetailRepository;
import communityWardrobe.tiacloud.repository.OrderRepository;
import communityWardrobe.tiacloud.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
      orderDetailEntity.setQuantity(inventoryOrderDetailsDTO.getInventoryDetailsCopyDTO().getQuantity());
      orderDetailEntity.setSize(inventoryOrderDetailsDTO.getInventoryDetailsCopyDTO().getSize());
      orderDetailEntity.setType(inventoryOrderDetailsDTO.getInventoryDetailsCopyDTO().getType());
      orderDetailRepository.save(orderDetailEntity);

    }

  }

  @Override
  public OrderDTO getOrder(Integer orderId) {
    OrderEntity orderEntity = orderRepository.findByOrderId(orderId);
    if(orderEntity !=null) {
      List<OrderDetailEntity> orderDetailEntityList = orderDetailRepository.findByOrderId(orderId);
      OrderDTO orderDTO = new OrderDTO();

      UserAddressDTO userAddressDTO = new UserAddressDTO();
      userAddressDTO.setUserName(orderEntity.getUserName());
      userAddressDTO.setAddress(orderEntity.getAddress());
      orderDTO.setUserAddressDTO(userAddressDTO);
      List<InventoryOrderDetailsDTO> inventoryOrderDetailsDTOList = new ArrayList<>();

      for (OrderDetailEntity orderDetailEntity : orderDetailEntityList) {
        InventoryOrderDetailsDTO inventoryOrderDetailsDTO = new InventoryOrderDetailsDTO();
        inventoryOrderDetailsDTO.setCategory(orderDetailEntity.getCategory());

        InventoryDetailsCopyDTO inventoryDetailsCopyDTO = new InventoryDetailsCopyDTO();
        inventoryDetailsCopyDTO.setQuantity(orderDetailEntity.getQuantity());
        inventoryDetailsCopyDTO.setSize(orderDetailEntity.getSize());
        inventoryDetailsCopyDTO.setType(orderDetailEntity.getType());
        inventoryOrderDetailsDTO.setInventoryDetailsCopyDTO(inventoryDetailsCopyDTO);

        inventoryOrderDetailsDTOList.add(inventoryOrderDetailsDTO);
      }

      orderDTO.setInventoryOrderDetailsDTOList(inventoryOrderDetailsDTOList);
      return orderDTO;
    }
    return null;
  }
}