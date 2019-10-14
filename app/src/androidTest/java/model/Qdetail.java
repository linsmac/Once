package model;

public class Qdetail {
    private String einNumber;
    private String einID;
    private int encodingID;
    private String product;
    private int amount;
    private int salesAmount;



    public Qdetail(String einNumber, String einID, int encodingID, String product, int amount, int salesAmount) {
        setEinNumber(einNumber);
        setEinID(einNumber+einID);
        setEncodingID(encodingID);
        setProduct(product);
        setAmount(amount);
        setSalesAmount(salesAmount);
    }


    public String getEinNumber() {
        return einNumber;
    }

    private void setEinNumber(String einNumber) {
        this.einNumber = einNumber;
    }



    public String getProduct() {
        return product;
    }

    private void setProduct(String product) {
        this.product = product;
    }

    public int getEncodingID() {
        return encodingID;
    }

    private void setEncodingID(int encodingID) {
        this.encodingID = encodingID;
    }

    public int getAmount() {
        return amount;
    }

    private void setAmount(int amount) {
        this.amount = amount;
    }

    public int getSalesAmount() {
        return salesAmount;
    }

    private void setSalesAmount(int salesAmount) {
        this.salesAmount = salesAmount;
    }


    public String getEinID() {
        return einID;
    }


    private void setEinID(String einID) {
        this.einID = einID;
    }


}