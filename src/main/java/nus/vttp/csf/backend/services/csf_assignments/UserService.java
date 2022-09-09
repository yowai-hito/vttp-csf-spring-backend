package nus.vttp.csf.backend.services.csf_assignments;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import net.minidev.json.JSONObject;
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
        responseHeaders.set("Accept", "application/json");
        responseBody.setData(buildUserJson(request));
        responseBody.setStatus(SUCCESS_STATUS);
        
        // return ResponseEntity.status(responseStatus).headers(responseHeaders).body(responseBody);
        return new ResponseEntity<>(responseBody, responseHeaders, responseStatus);
    }

    private JSONObject buildUserJson(RegistrationRequest request) {
        JSONObject userData = new JSONObject();
        userData.put("id", request.getId());
        userData.put("name", request.getName());
        userData.put("email", request.getEmail());
        return userData;
    }
}
