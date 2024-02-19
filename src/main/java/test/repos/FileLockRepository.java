package test.repos;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.entity.FileLock;

@Repository
public interface FileLockRepository {

    FileLock findByFileName(String fileName);
}
