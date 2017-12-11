package com.jhonlee.sywj.pojo;

import java.util.List;

/**
 * @author <font color="pink"><b>JhoneLee</b></font>
 * @Date 2017/12/8
 * @Version 1.0
 * @Description
 */
public class Result {

    /**
     * InfoID : 1331090000000047
     * Heading : 下水道堵塞致一楼被淹，业主起诉楼上居民获赔
     * IssueDate : 2017-11-06 14:46:26
     * ImageUrl : http://125.64.16.10:1331/HM/M_Main/UploadFiles/2017/11/2017116145846444..jpg
     */
    private String InfoID;
    private String Heading;
    private String IssueDate;
    private String ImageUrl;

    public String getInfoID() {
        return InfoID;
    }

    public void setInfoID(String InfoID) {
        this.InfoID = InfoID;
    }

    public String getHeading() {
        return Heading;
    }

    public void setHeading(String Heading) {
        this.Heading = Heading;
    }

    public String getIssueDate() {
        return IssueDate;
    }

    public void setIssueDate(String IssueDate) {
        this.IssueDate = IssueDate;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String ImageUrl) {
        this.ImageUrl = ImageUrl;
    }

}
