package com.we.once;
public class PostModel {
    private String mDate;
    private String mType;
    private String mMoney;
    private String mColor;

    public PostModel(String date, String type, String money, String color) {
        this.mDate = date;
        this.mType = type;
        this.mMoney = money;
        this.mColor = color;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String mDate) {
        this.mDate = mDate;
    }

    public String getType() {
        return mType;
    }

    public void setType(String mType) {
        this.mType = mType;
    }

    public String getMoney() {
        return mMoney;
    }

    public void setMoney(String mMoney) {
        this.mMoney = mMoney;
    }

    public String getColor() {
        return mColor;
    }
}
