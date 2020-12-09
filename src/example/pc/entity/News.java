package example.pc.entity;

import java.util.Date;

public class News extends BaseModel{
    private String title;
    private String body;
    private String newsType;
    private Date date;
    private int toTop;


    public int getToTop() {
        return toTop;
    }

    public void setToTop(int toTop) {
        this.toTop = toTop;
    }

    public String getTitle() {
        return title;

    }

    public String getNewsType() {
        return newsType;
    }

    public void setNewsType(String newsType) {
        this.newsType = newsType;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
