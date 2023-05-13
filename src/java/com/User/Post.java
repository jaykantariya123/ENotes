/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.User;

import java.sql.Date;

/**
 *
 * @author hp
 */
public class Post {
    private  String title;
    private String content;
    private Date pdate;
    private UserDetails user;

    public Post() {
    }

    public Post(String title, String content, Date pdate, UserDetails user) {
        this.title = title;
        this.content = content;
        this.pdate = pdate;
        this.user = user;
    }

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

    public Date getPdate() {
        return pdate;
    }

    public void setPdate(Date pdate) {
        this.pdate = pdate;
    }

    public UserDetails getUser() {
        return user;
    }

    public void setUser(UserDetails user) {
        this.user = user;
    }
    
}
