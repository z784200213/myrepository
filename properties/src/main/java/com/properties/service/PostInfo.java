package com.properties.service;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/*@Data
@ConfigurationProperties*/
public class PostInfo {
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private String title;
    private String content;
}
