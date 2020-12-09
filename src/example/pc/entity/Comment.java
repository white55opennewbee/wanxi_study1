package example.pc.entity;


import java.sql.Date;

public class Comment extends BaseModel{
    private String commonUsername;
    private String userEmail;
    private String userCommon;
    private Date commonTime;
    public Comment(){
        commonTime = new Date(System.currentTimeMillis());
    }


    public Date getCommonTime() {
        return commonTime;
    }

    public void setCommonTime(Date commonTime) {
        this.commonTime = commonTime;
    }

    public String getCommonUsername() {
        return commonUsername;
    }

    public void setCommonUsername(String commonUsername) {
        this.commonUsername = commonUsername;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserCommon() {
        return userCommon;
    }

    public void setUserCommon(String userCommon) {
        this.userCommon = userCommon;
    }
}
