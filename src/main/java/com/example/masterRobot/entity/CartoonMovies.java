package com.example.masterRobot.entity;

import javax.persistence.*;

@Entity
@Table(name="cartoon_movies")
public class CartoonMovies {
    @Id
    @Column(name = "item_id", nullable = false)
    private long itemId;
    @Column(name = "title")
    private String title;

    @Column(name = "studio_name")
    private String stuioName;

    @Column(name = "description")
    private String description;

    public CartoonMovies() {
    }

    public CartoonMovies(long itemId, String title, String stuioName, String description) {
        this.itemId = itemId;
        this.title = title;
        this.stuioName = stuioName;
        this.description = description;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStuioName() {
        return stuioName;
    }

    public void setStuioName(String stuioName) {
        this.stuioName = stuioName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CartoonMovies{" +
                "itemId=" + itemId +
                ", title='" + title + '\'' +
                ", stuioName='" + stuioName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
