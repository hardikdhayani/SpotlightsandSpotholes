package hjddevs.spotlightsandspotholes.com.spotlightsandspotholes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class UserProfile {
    public String userPincode;
    public String userEmail;
    public String userName;

    public UserProfile(){
    }

    public UserProfile(String userPincode, String userEmail, String userName) {
        this.userPincode = userPincode;
        this.userEmail = userEmail;
        this.userName = userName;
    }

    public String getUserPincode() {
        return userPincode;
    }

    public void setUserPincode(String userPincode) {
        this.userPincode = userPincode;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
