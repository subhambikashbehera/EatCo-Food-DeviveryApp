package com.edusy.eatco.DataModel;

public class CartModel {

    int orderimage;
    String solditemname,soldprice,ordernumber;

    public CartModel(int orderimage, String solditemname, String soldprice, String ordernumber) {
        this.orderimage = orderimage;
        this.solditemname = solditemname;
        this.soldprice = soldprice;
        this.ordernumber = ordernumber;
    }

    public CartModel() {

    }

    public int getOrderimage() {
        return orderimage;
    }

    public void setOrderimage(int orderimage) {
        this.orderimage = orderimage;
    }

    public String getSolditemname() {
        return solditemname;
    }

    public void setSolditemname(String solditemname) {
        this.solditemname = solditemname;
    }

    public String getSoldprice() {
        return soldprice;
    }

    public void setSoldprice(String soldprice) {
        this.soldprice = soldprice;
    }

    public String getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(String ordernumber) {
        this.ordernumber = ordernumber;
    }
}
