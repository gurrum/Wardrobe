package communityWardrobe.tiacloud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import communityWardrobe.tiacloud.model.entity.InventoryEntity;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface InventoryRepository extends CrudRepository<InventoryEntity, Integer> {

	@Query("SELECT DISTINCT i.category FROM InventoryEntity i")
	List<String> findDistinctCategory();
	
	List<InventoryEntity> findByCategory(String category);
}