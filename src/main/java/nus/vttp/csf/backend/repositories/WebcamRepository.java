package nus.vttp.csf.backend.repositories;

import java.sql.ResultSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import static nus.vttp.csf.backend.configs.BackendConstants.*;

public class WebcamRepository {
    
    @Autowired
    JdbcTemplate jdbc;

    private Logger LOG = LoggerFactory.getLogger(WebcamRepository.class.getName());

    public int uploadImageWithCaption(String imageUrl, String caption){
        return jdbc.update(SQL_UPLOAD_IMAGE_CAPTION, imageUrl, caption);    
    }

}
