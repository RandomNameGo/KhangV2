package swp.internmanagement.internmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swp.internmanagement.internmanagement.entity.UserAccount;
import swp.internmanagement.internmanagement.repository.UserAccountRepository;

import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    private UserAccountRepository userAccountRepository;


    @Override
    public List<UserAccount> getAllUserAccountsByParam(String param) {
        return userAccountRepository.findUserAccountByParam(param);
    }
}
