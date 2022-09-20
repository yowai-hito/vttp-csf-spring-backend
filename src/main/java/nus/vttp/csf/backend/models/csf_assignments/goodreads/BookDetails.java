package nus.vttp.csf.backend.models.csf_assignments.goodreads;

import java.util.Optional;

import net.minidev.json.JSONObject;

public class BookDetails {
    private String id = "";
    private String title = "";
    private String author = "";
    private String description = "";
    private Optional<Integer> pages = Optional.empty();
    private Optional<Integer> ratingCount = Optional.empty();
    private Optional<Integer> reviewCount = Optional.empty();
    private Optional<Float> rating = Optional.empty();
    private String genre = "";
    private String imageUrl = "";

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
  
    public Optional<Integer> getPages() {
        return pages;
    }
    public void setPages(Optional<Integer> pages) {
        this.pages = pages;
    }
    public Optional<Integer> getRatingCount() {
        return ratingCount;
    }
    public void setRatingCount(Optional<Integer> ratingCount) {
        this.ratingCount = ratingCount;
    }
    public Optional<Integer> getReviewCount() {
        return reviewCount;
    }
    public void setReviewCount(Optional<Integer> reviewCount) {
        this.reviewCount = reviewCount;
    }
    public Optional<Float> getRating() {
        return rating;
    }
    public void setRating(Optional<Float> rating) {
        this.rating = rating;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public JSONObject toJson() {
        JSONObject bookDetails = new JSONObject();
        if (!this.id.isEmpty()){
            bookDetails.put("book_id", getId());
        }
        if (!this.title.isEmpty()){
            bookDetails.put("title", getTitle());
        }
        if (!this.author.isEmpty()){
            bookDetails.put("author", getAuthor());
        }
        if (!this.description.isEmpty()){
            bookDetails.put("description", getDescription());
        }
        if (this.rating.isPresent()){
            bookDetails.put("rating", this.rating.get());
        }
        if (this.ratingCount.isPresent()){
            bookDetails.put("rating_count", this.ratingCount.get());
        }
        if (this.reviewCount.isPresent()){
            bookDetails.put("review_count", getReviewCount());
        }
        if (this.pages.isPresent()){
            bookDetails.put("pages", this.pages.get());
        }
        if (!this.genre.isEmpty()){
            bookDetails.put("genre", getGenre());
        }
        if (!this.imageUrl.isEmpty()){
            bookDetails.put("image_url", getImageUrl());
        }
        return bookDetails;
    }
}
