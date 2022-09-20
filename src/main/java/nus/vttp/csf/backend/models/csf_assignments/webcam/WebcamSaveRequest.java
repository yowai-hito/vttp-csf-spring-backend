package nus.vttp.csf.backend.models.csf_assignments.webcam;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class WebcamSaveRequest {
    @NotNull
    @NotBlank
    private String caption;

    @NotNull
    @NotBlank
    private String imageUrl;

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    
}
