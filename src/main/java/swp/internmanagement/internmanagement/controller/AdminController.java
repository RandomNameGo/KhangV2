package swp.internmanagement.internmanagement.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import swp.internmanagement.internmanagement.entity.Request;
import swp.internmanagement.internmanagement.entity.UserAccount;
import swp.internmanagement.internmanagement.service.RequestService;
import swp.internmanagement.internmanagement.service.UserAccountService;

import java.util.List;

@RestController
@RequestMapping("/internBridge/admin")
public class AdminController {

    @Autowired
    private RequestService requestService;

    @Autowired
    private UserAccountService userAccountService;

    @GetMapping("/getRequest")
    public ResponseEntity<List<Request>> getRequests(){
        return ResponseEntity.ok(requestService.getRequests());
    }

    @GetMapping("/search={companyName}")
    public ResponseEntity<List<UserAccount>> getAllUserAccountsByParam(@PathVariable String companyName) {
        return ResponseEntity.ok(userAccountService.getAllUserAccountsByParam(companyName));
    }

}
