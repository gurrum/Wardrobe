package communityWardrobe.tiacloud.repository;

import communityWardrobe.tiacloud.model.entity.DonationEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface DonationRepository extends CrudRepository<DonationEntity, Integer> {

	
	DonationEntity findByDonationId(String donationId);
}