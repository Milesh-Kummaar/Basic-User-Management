package Management.User.repository;


import Management.User.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SchoolRepository extends JpaRepository<School,String> {
      School findByUsername(String username);
      boolean existsByUsername(String username);
      boolean existsByEmailid(String emailid);
      boolean existsByPhonenumber(String phonenumber);


}
