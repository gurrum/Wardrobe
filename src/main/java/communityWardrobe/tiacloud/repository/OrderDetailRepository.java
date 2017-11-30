package communityWardrobe.tiacloud.repository;

import communityWardrobe.tiacloud.model.entity.OrderDetailEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface OrderDetailRepository extends CrudRepository<OrderDetailEntity, Integer> {
  OrderDetailEntity findByOId(Integer oId);

  List<OrderDetailEntity> findByOrderId(Integer orderId);


}
