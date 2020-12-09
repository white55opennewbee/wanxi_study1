package example.pc.entity;

public class Company extends BaseModel {

    private String companyName;
    private String symbol;
    private String imgUrl;
    private String callUsIntroduce;
    private String aboutUsIntroduce;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getCallUsIntroduce() {
        return callUsIntroduce;
    }

    public void setCallUsIntroduce(String callUsIntroduce) {
        this.callUsIntroduce = callUsIntroduce;
    }

    public String getAboutUsIntroduce() {
        return aboutUsIntroduce;
    }

    public void setAboutUsIntroduce(String aboutUsIntroduce) {
        this.aboutUsIntroduce = aboutUsIntroduce;
    }
}
