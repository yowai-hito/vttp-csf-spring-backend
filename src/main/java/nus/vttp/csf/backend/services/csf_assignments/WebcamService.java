package nus.vttp.csf.backend.services.csf_assignments;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import nus.vttp.csf.backend.models.common.CsfResponse;
import nus.vttp.csf.backend.models.csf_assignments.webcam.WebcamSaveRequest;
import nus.vttp.csf.backend.repositories.WebcamRepository;

public class WebcamService {
    
    final String SUCCESS_STATUS = "success";

    @Autowired
    WebcamRepository webcamRepository;

    public ResponseEntity<Object> uploadImageCaption (WebcamSaveRequest request) {
        CsfResponse responseBody = new CsfResponse();
        HttpHeaders responseHeaders = new HttpHeaders();
        HttpStatus responseStatus = HttpStatus.resolve(200);
        int result = webcamRepository.uploadImageWithCaption(request.getImageUrl(), request.getCaption());
        if (result >= 0){
            responseBody.setData(result + " row(s) have been inserted.");
        } else { responseBody.setError("Error, upload failed"); }
        responseHeaders.set("Content-Type","application/json");
        responseHeaders.set("Accept", "application/json");

        responseBody.setStatus(SUCCESS_STATUS);
        
        return new ResponseEntity<>(responseBody, responseHeaders, responseStatus);
    }

}
