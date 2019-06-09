package hjddevs.spotlightsandspotholes.com.spotlightsandspotholes;


public class Upload {
    private String imgName;
    private String imgUrl;
    private String location;
    private String mobilenumbera;

    public Upload() {
    }

    public Upload(String imgName, String imgUrl,String location,String mobilenumbera) {
        if(imgName.trim().equals(""))
        {
            imgName="No Description";
        }
        this.imgName = imgName;
        this.imgUrl = imgUrl;
        this.location = location;
        this.mobilenumbera = mobilenumbera;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getImgUrl() {
        return imgUrl;
    }
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }


    public String getMobileNumber() {
        return mobilenumbera;
    }
    public void setMobileNumber(String mobilenumber) {
        this.mobilenumbera = mobilenumber;
    }





}
