package com.jikexueyuan.baiduwaimaicopy;


/**
 * 我的页ListView的数据项模型类
 */
public class MineModel {

    private int resLeftResource;//列表项左边图片的数据来源
    private String text;//列表项文字
    private int resRightResource;//列表项右边图片的数据来源

    public int getResLeftResource() {
        return resLeftResource;
    }

    public int getResRightResource() {
        return resRightResource;
    }

    public String getText() {
        return text;
    }

    public void setResLeftResource(int resLeftResource) {
        this.resLeftResource = resLeftResource;
    }

    public void setResRightResource(int resRightResource) {
        this.resRightResource = resRightResource;
    }

    public void setText(String text) {
        this.text = text;
    }
}
