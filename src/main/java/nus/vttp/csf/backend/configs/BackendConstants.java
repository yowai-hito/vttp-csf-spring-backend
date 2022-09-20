package nus.vttp.csf.backend.configs;

public class BackendConstants {
    //Goodreads
    public static final String SQL_SELECT_BOOK_DISPLAY_DETAILS = 
    "SELECT book_id, title, image_url FROM goodreads.book2018 LIMIT ? OFFSET ?";
    public static final String SQL_SELECT_BOOK_DETAILS_WITH_ID = 
    "SELECT * FROM goodreads.book2018 WHERE book_id = ?";
    //Webcam
    public static final String SQL_UPLOAD_IMAGE_CAPTION = 
    "INSERT INTO webcam.images (image, caption) VALUES (?,?)";
}
