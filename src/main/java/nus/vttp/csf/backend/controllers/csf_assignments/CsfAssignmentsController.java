package nus.vttp.csf.backend.controllers.csf_assignments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nus.vttp.csf.backend.models.csf_assignments.RegistrationRequest;
import nus.vttp.csf.backend.services.csf_assignments.UserService;

@RestController
@RequestMapping(path="/csf/assignemnts")
public class CsfAssignmentsController {
    
    private UserService userService;

    @Autowired
    public CsfAssignmentsController(UserService userService) {
        this.userService = userService;
    } 

    @PostMapping(path="/register")
    public ResponseEntity<Object> doRegistration(RegistrationRequest req) {
        return this.userService.registerUser(req); 
    }

}
