package com.example.item;

public class Bannermodel {
    private String banner_id;
    private String banner_link;
    private String banner_image;

    public Bannermodel(String banner_id, String banner_link, String banner_image) {
        this.banner_id = banner_id;
        this.banner_link = banner_link;
        this.banner_image = banner_image;
    }

    public String getBanner_id() {
        return banner_id;
    }

    public void setBanner_id(String banner_id) {
        this.banner_id = banner_id;
    }

    public String getBanner_link() {
        return banner_link;
    }

    public void setBanner_link(String banner_link) {
        this.banner_link = banner_link;
    }

    public String getBanner_image() {
        return banner_image;
    }

    public void setBanner_image(String banner_image) {
        this.banner_image = banner_image;
    }
}
