package example.pc.entity;

public class Production extends BaseModel{
    private String productionName;
    private String productionImgUrl;
    private String price;
    private String type;
    private Integer number;
    private String exportPlace;
    private String incountryPlace;
    private String tradeTime;


    public String getProductionName() {
        return productionName;
    }

    public void setProductionName(String productionName) {
        this.productionName = productionName;
    }

    public String getProductionImgUrl() {
        return productionImgUrl;
    }

    public void setProductionImgUrl(String productionImgUrl) {
        this.productionImgUrl = productionImgUrl;
    }//

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getExportPlace() {
        return exportPlace;
    }

    public void setExportPlace(String exportPlace) {
        this.exportPlace = exportPlace;
    }

    public String getIncountryPlace() {
        return incountryPlace;
    }

    public void setIncountryPlace(String incountryPlace) {
        this.incountryPlace = incountryPlace;
    }

    public String getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(String tradeTime) {
        this.tradeTime = tradeTime;
    }

    @Override
    public String toString() {
        return "Production{" +
                "productionName='" + productionName + '\'' +
                ", productionImgUrl='" + productionImgUrl + '\'' +
                ", price='" + price + '\'' +
                ", type='" + type + '\'' +
                ", number='" + number + '\'' +
                ", exportPlace='" + exportPlace + '\'' +
                ", incountryPlace='" + incountryPlace + '\'' +
                ", tradeTime='" + tradeTime + '\'' +
                '}';
    }
}
