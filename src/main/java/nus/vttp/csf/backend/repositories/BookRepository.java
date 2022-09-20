package nus.vttp.csf.backend.repositories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import nus.vttp.csf.backend.models.csf_assignments.goodreads.BookDetails;

import static nus.vttp.csf.backend.configs.BackendConstants.*;

import java.sql.ResultSet;
import java.util.Optional;

@Repository
public class BookRepository {
    
    @Autowired
    JdbcTemplate jdbc;

    private Logger LOG = LoggerFactory.getLogger(BookRepository.class.getName());

    public Optional<JSONArray> getBooksByLimitAndOffset(int limit, int offset){
        try {
            return jdbc.query(SQL_SELECT_BOOK_DISPLAY_DETAILS, 
            (ResultSet rs) -> {
                JSONArray books = new JSONArray();
                while (rs.next()){
                    BookDetails bookDetails = new BookDetails();
                    bookDetails.setId(rs.getString("book_id"));
                    bookDetails.setTitle(rs.getString("title"));
                    bookDetails.setImageUrl(rs.getString("image_url"));
                    books.add(bookDetails.toJson());
                }
                return Optional.of(books);
            },
            limit, offset);
        } catch (Exception e) {
            return Optional.empty();
        }
            
    }

    public Optional<JSONObject> getBookDetailsById(String bookId){
        return jdbc.query(SQL_SELECT_BOOK_DETAILS_WITH_ID, 
        (ResultSet rs) -> {
            if (!rs.next()){return Optional.empty();}
            BookDetails bookDetails = new BookDetails();
            bookDetails.setId(rs.getString("book_id"));
            bookDetails.setAuthor(rs.getString("authors"));
            bookDetails.setTitle(rs.getString("title"));
            bookDetails.setDescription(rs.getString("description"));
            bookDetails.setPages(Optional.of(rs.getInt("pages")));
            bookDetails.setRating(Optional.of(rs.getFloat("rating")));
            bookDetails.setRatingCount(Optional.of(rs.getInt("rating_count")));
            bookDetails.setReviewCount(Optional.of(rs.getInt("review_count")));
            bookDetails.setGenre(rs.getString("genres"));
            bookDetails.setImageUrl(rs.getString("image_url"));
            return Optional.of(bookDetails.toJson());
        },
        bookId);
    }
}
