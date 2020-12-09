package example.pc.entity;

public class Nav extends BaseModel {
    private String href;
    private String describe;
    private String title;
    private String usPagename;

    public String getUsPagename() {
        return usPagename;
    }

    public void setUsPagename(String usPagename) {
        this.usPagename = usPagename;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
