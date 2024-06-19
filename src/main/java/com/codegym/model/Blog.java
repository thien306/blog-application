package com.codegym.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "blog")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(columnDefinition = "text")
    private String content;

    @Column(name = "blogger_name")
    private String bloggerName;

    @Column(name = "day_write")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dayWrite;

    public Blog() {

    }

    public Blog(Long id, String name, String content, String bloggerName, Date dayWrite) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.bloggerName = bloggerName;
        this.dayWrite = dayWrite;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getBloggerName() {
        return bloggerName;
    }

    public void setBloggerName(String bloggerName) {
        this.bloggerName = bloggerName;
    }

    public Date getDayWrite() {
        return dayWrite;
    }

    public void setDayWrite(Date dayWrite) {
        this.dayWrite = dayWrite;
    }
}
