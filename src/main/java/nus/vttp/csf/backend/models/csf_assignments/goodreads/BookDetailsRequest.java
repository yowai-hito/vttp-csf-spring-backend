package nus.vttp.csf.backend.models.csf_assignments.goodreads;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class BookDetailsRequest {
    
    @NotNull
    @NotBlank
    private String bookId;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
}
