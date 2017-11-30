package communityWardrobe.tiacloud.repository;

import communityWardrobe.tiacloud.model.entity.NGOEntity;
import communityWardrobe.tiacloud.model.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface UserRepository extends CrudRepository<UserEntity, String> {

	
	UserEntity findByuserName(String userName);
}