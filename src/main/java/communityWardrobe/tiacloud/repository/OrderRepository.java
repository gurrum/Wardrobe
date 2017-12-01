package communityWardrobe.tiacloud.repository;

import communityWardrobe.tiacloud.model.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface OrderRepository extends CrudRepository<OrderEntity, Integer> {
  OrderEntity findByOrderId(Integer orderId);

  List<OrderEntity> findByUserName(String userName);


}
