package swp.internmanagement.internmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import swp.internmanagement.internmanagement.entity.MentorFeedbackIntern;
import swp.internmanagement.internmanagement.payload.request.MentorFeedbackInternRequest;
import swp.internmanagement.internmanagement.service.MentorFeedbackInternService;

@RestController
@RequestMapping("internBridge/mentor")
public class MentorController {

    @Autowired
    private MentorFeedbackInternService mentorFeedbackInternService;

    @PostMapping("/sendFeedback")
    public ResponseEntity<MentorFeedbackIntern> sendFeedback(@RequestBody MentorFeedbackInternRequest mentorFeedbackInternRequest) {
        return new ResponseEntity<>(mentorFeedbackInternService.sendFeedbackIntern(mentorFeedbackInternRequest), HttpStatus.CREATED);
    }
}
