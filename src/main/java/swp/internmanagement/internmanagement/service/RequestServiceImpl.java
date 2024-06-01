package swp.internmanagement.internmanagement.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swp.internmanagement.internmanagement.entity.Request;
import swp.internmanagement.internmanagement.entity.UserAccount;
import swp.internmanagement.internmanagement.payload.request.HelpRequest;
import swp.internmanagement.internmanagement.repository.RequestRepository;
import swp.internmanagement.internmanagement.repository.UserAccountRepository;

import java.util.List;


@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Override
    public Request saveRequest(HelpRequest helpRequest) {
        Request request = new Request();
        UserAccount userAccount = new UserAccount();
        int userId = helpRequest.getSenderId();
        userAccount = userAccountRepository.findById(userId).get();
        request.setUser(userAccount);
        request.setRequestType(helpRequest.getHelpType());
        request.setRequestContent(helpRequest.getHelpContent());
        requestRepository.save(request);
        return request;
    }

    @Override
    public List<Request> getRequests() {
        return requestRepository.findAll();
    }


}
