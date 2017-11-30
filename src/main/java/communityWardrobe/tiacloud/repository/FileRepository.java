package communityWardrobe.tiacloud.repository;

import communityWardrobe.tiacloud.model.entity.FileEntity;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.lang.String;
import java.util.List;

public interface FileRepository extends CrudRepository<FileEntity, Long>{

	List<FileEntity> findByBucketName(String bucketname);
	List<FileEntity> findByFolderName(String foldername);
	List<FileEntity> findByFileKey(String filekey);
	@Query("SELECT p.fileKey FROM FileEntity p where p.bucketName = :bucketName AND p.folderName= :folderName AND p.locX= :locX AND p.locY= :locY") 
    String findFileKeyByLoc(@Param("bucketName") String bucketName, @Param("folderName") String folderName,@Param("locX") Double locX,@Param("locY") Double locY);
}