package communityWardrobe.tiacloud.repository;

import communityWardrobe.tiacloud.model.entity.NGOEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface NGORepository extends CrudRepository<NGOEntity, String> {

	
	NGOEntity findByname(String name);
}