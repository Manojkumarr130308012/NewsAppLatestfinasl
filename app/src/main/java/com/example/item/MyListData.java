package com.example.item;

public class MyListData {
    private String reporter_name;
    private String reporter_id;
    private String reporter_mobile;
    private String reporter_city;
    private int imgId;

    public MyListData(String reporter_name, String reporter_id, String reporter_mobile, String reporter_city, int imgId) {
        this.reporter_name = reporter_name;
        this.reporter_id = reporter_id;
        this.reporter_mobile = reporter_mobile;
        this.reporter_city = reporter_city;
        this.imgId = imgId;
    }

    public String getReporter_name() {
        return reporter_name;
    }

    public void setReporter_name(String reporter_name) {
        this.reporter_name = reporter_name;
    }

    public String getReporter_id() {
        return reporter_id;
    }

    public void setReporter_id(String reporter_id) {
        this.reporter_id = reporter_id;
    }

    public String getReporter_mobile() {
        return reporter_mobile;
    }

    public void setReporter_mobile(String reporter_mobile) {
        this.reporter_mobile = reporter_mobile;
    }

    public String getReporter_city() {
        return reporter_city;
    }

    public void setReporter_city(String reporter_city) {
        this.reporter_city = reporter_city;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }
}
