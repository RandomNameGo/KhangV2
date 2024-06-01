package swp.internmanagement.internmanagement.service;

import swp.internmanagement.internmanagement.entity.UserAccount;

import java.util.List;

public interface UserAccountService {

    List<UserAccount> getAllUserAccountsByParam(String param);
}
