package com.jikexueyuan.baiduwaimaicopy;


/**
 * 首页ListView的数据项模型类
 */
public class HomeModel {

    private int leftResResource;//最左边显示的图片资源
    private String shopName;//店铺的名字
    private int brightStarNum;//亮星个数
    private int selfStarNum;//半星个数
    private int dimStarNum;//暗星个数
    private String salesCondition;//售卖情况
    private String transportCondition;//运送情况
    private boolean isListJian;//是否高亮显示减
    private boolean isListQuan;//是否高亮显示券
    private boolean isListMian;//是否高亮显示免
    private String distance;//运送需要的路程

    public int getLeftResResource() {
        return leftResResource;
    }

    public void setLeftResResource(int leftResResource) {
        this.leftResResource = leftResResource;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public int getBrightStarNum() {
        return brightStarNum;
    }

    public void setBrightStarNum(int brightStarNum) {
        this.brightStarNum = brightStarNum;
    }

    public int getSelfStarNum() {
        return selfStarNum;
    }

    public void setSelfStarNum(int selfStarNum) {
        this.selfStarNum = selfStarNum;
    }

    public int getDimStarNum() {
        return dimStarNum;
    }

    public void setDimStarNum(int dimStarNum) {
        this.dimStarNum = dimStarNum;
    }

    public String getSalesCondition() {
        return salesCondition;
    }

    public void setSalesCondition(String salesCondition) {
        this.salesCondition = salesCondition;
    }

    public String getTransportCondition() {
        return transportCondition;
    }

    public void setTransportCondition(String transportCondition) {
        this.transportCondition = transportCondition;
    }

    public boolean isListJian() {
        return isListJian;
    }

    public void setIsListJian(boolean isListJian) {
        this.isListJian = isListJian;
    }

    public boolean isListQuan() {
        return isListQuan;
    }

    public void setIsListQuan(boolean isListQuan) {
        this.isListQuan = isListQuan;
    }

    public boolean isListMian() {
        return isListMian;
    }

    public void setIsListMian(boolean isListMian) {
        this.isListMian = isListMian;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }
}
