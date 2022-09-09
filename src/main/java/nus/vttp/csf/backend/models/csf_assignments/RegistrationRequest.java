package nus.vttp.csf.backend.models.csf_assignments;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class RegistrationRequest {
    
    @NotNull
    @NotBlank
    private String id;

    @NotNull
    @NotBlank
    private String name;
    
    @NotNull
    @NotBlank
    private String email;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    
}
