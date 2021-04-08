package com.example.item;

public class Tipsmodel {
    private String tips_id;
    private String tips_name;
    private String tips_desc;
    private String tips_image;

    public Tipsmodel(String tips_id, String tips_name, String tips_desc, String tips_image) {
        this.tips_id = tips_id;
        this.tips_name = tips_name;
        this.tips_desc = tips_desc;
        this.tips_image = tips_image;
    }


    public String getTips_id() {
        return tips_id;
    }

    public void setTips_id(String tips_id) {
        this.tips_id = tips_id;
    }

    public String getTips_name() {
        return tips_name;
    }

    public void setTips_name(String tips_name) {
        this.tips_name = tips_name;
    }

    public String getTips_desc() {
        return tips_desc;
    }

    public void setTips_desc(String tips_desc) {
        this.tips_desc = tips_desc;
    }

    public String getTips_image() {
        return tips_image;
    }

    public void setTips_image(String tips_image) {
        this.tips_image = tips_image;
    }
}
