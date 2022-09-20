package nus.vttp.csf.backend.models.csf_assignments.goodreads;

import javax.validation.constraints.NotNull;

public class BookListRequest {
    
    @NotNull
    private int limit;

    @NotNull
    private int offset;

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
    
    

}
