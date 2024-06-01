package swp.internmanagement.internmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import swp.internmanagement.internmanagement.entity.UserAccount;

import java.util.List;

public interface UserAccountRepository extends JpaRepository<UserAccount, Integer> {

    @Query("select u from UserAccount u where u.company.companyName like %?1% or u.role like %?1%")
    List<UserAccount> findUserAccountByParam(String param);
}