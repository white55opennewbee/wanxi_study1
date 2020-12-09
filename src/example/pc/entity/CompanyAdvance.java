package example.pc.entity;

public class CompanyAdvance extends BaseModel{
    private String imgUrl;
    private String info ;

    public String getImgUrl() {
        return imgUrl;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "CompanyAdvance{" +
                "imgUrl='" + imgUrl + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
