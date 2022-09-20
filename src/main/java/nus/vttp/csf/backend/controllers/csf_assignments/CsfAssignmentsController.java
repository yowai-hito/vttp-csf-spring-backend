package nus.vttp.csf.backend.controllers.csf_assignments;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nus.vttp.csf.backend.models.csf_assignments.RegistrationRequest;
import nus.vttp.csf.backend.models.csf_assignments.goodreads.BookDetailsRequest;
import nus.vttp.csf.backend.models.csf_assignments.goodreads.BookListRequest;
import nus.vttp.csf.backend.models.csf_assignments.webcam.WebcamSaveRequest;
import nus.vttp.csf.backend.services.csf_assignments.BookService;
import nus.vttp.csf.backend.services.csf_assignments.UserService;
import nus.vttp.csf.backend.services.csf_assignments.WebcamService;

@RestController
@RequestMapping(path="/csf/assignments")
public class CsfAssignmentsController {
    
    private UserService userService;
    private BookService bookService;
    private WebcamService webcamService;

    @Autowired
    public CsfAssignmentsController(UserService userService, BookService bookService, WebcamService webcamService) { 
        this.userService = userService;
        this.bookService = bookService;
        this.webcamService = webcamService;
    } 

    @CrossOrigin
    @PostMapping(path="/register")
    public ResponseEntity<Object> doRegistration(@Valid @RequestBody RegistrationRequest req) {
        return this.userService.registerUser(req); 
    }

    @PostMapping(path="/book/list")
    public ResponseEntity<Object> getBookList(@Valid @RequestBody BookListRequest req) {
        return this.bookService.getBookList(req);
    }

    @PostMapping(path="/book/details")
    public ResponseEntity<Object> getBookDetails(@Valid @RequestBody BookDetailsRequest req) {
        return this.bookService.getBookDetails(req);
    }

    @PostMapping(path="/webcam/save")
    public ResponseEntity<Object> saveWebcamImage(@Valid @RequestBody WebcamSaveRequest req) {
        return this.webcamService.uploadImageCaption(req);
    }
}
