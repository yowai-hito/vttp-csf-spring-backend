package nus.vttp.csf.backend.services.csf_assignments;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import nus.vttp.csf.backend.models.common.CsfResponse;
import nus.vttp.csf.backend.models.csf_assignments.RegistrationRequest;

@Service
public class UserService {
    
    final String SUCCESS_STATUS = "success";

    public ResponseEntity<Object> registerUser (RegistrationRequest request) {
        CsfResponse responseBody = new CsfResponse();
        HttpHeaders responseHeaders = new HttpHeaders();
        HttpStatus responseStatus = HttpStatus.resolve(200);

        responseHeaders.set("Content-Type","application/json");
        responseBody.setData(buildUserJson(request));
        responseBody.setStatus(SUCCESS_STATUS);
        
        return new ResponseEntity<>(responseBody, responseHeaders, responseStatus);
    }

    private JsonObject buildUserJson(RegistrationRequest request) {
        return Json.createObjectBuilder()
            .add("id", request.getId())
            .add("name", request.getName())
            .add("email", request.getEmail())
            .build();
    }
}
