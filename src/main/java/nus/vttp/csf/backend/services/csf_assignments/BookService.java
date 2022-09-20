package nus.vttp.csf.backend.services.csf_assignments;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import nus.vttp.csf.backend.models.common.CsfResponse;
import nus.vttp.csf.backend.models.csf_assignments.goodreads.BookDetailsRequest;
import nus.vttp.csf.backend.models.csf_assignments.goodreads.BookListRequest;
import nus.vttp.csf.backend.repositories.BookRepository;

@Service
public class BookService {
    
    @Autowired
    BookRepository bookRepo;

    final String SUCCESS_STATUS = "success";
    final String APPLICATION_JSON = "application/json";

    public ResponseEntity<Object> getBookList (BookListRequest request) {
        CsfResponse responseBody = new CsfResponse();
        HttpHeaders responseHeaders = new HttpHeaders();
        HttpStatus responseStatus = HttpStatus.resolve(200);

        responseHeaders.set("Content-Type", APPLICATION_JSON);
        responseHeaders.set("Accept", APPLICATION_JSON);
        Optional<JSONArray> bookList = bookRepo.getBooksByLimitAndOffset(request.getLimit(), request.getOffset());
        if (bookList.isPresent()){
            responseBody.setData(bookList);
        } else {responseBody.setError("Error, book list could not be retrived");};
        responseBody.setStatus(SUCCESS_STATUS);
        
        return new ResponseEntity<>(responseBody, responseHeaders, responseStatus);
    }

    public ResponseEntity<Object> getBookDetails (BookDetailsRequest request) {
        CsfResponse responseBody = new CsfResponse();
        HttpHeaders responseHeaders = new HttpHeaders();
        HttpStatus responseStatus = HttpStatus.resolve(200);

        responseHeaders.set("Content-Type", APPLICATION_JSON);
        responseHeaders.set("Accept", APPLICATION_JSON);
        Optional<JSONObject> bookList = bookRepo.getBookDetailsById(request.getBookId());
        if (bookList.isPresent()){
            responseBody.setData(bookList);
        } else {responseBody.setError("Error, book list could not be retrived");};
        responseBody.setStatus(SUCCESS_STATUS);
        
        return new ResponseEntity<>(responseBody, responseHeaders, responseStatus);
    }

}