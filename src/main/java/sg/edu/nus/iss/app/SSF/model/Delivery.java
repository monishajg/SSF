package sg.edu.nus.iss.app.SSF.model;

//??? clean up later
import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

//  Validation(wrkshp13,14)
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Digits;

public class Delivery {
    
    @NotNull
    @Size(min =3)
    private String name;
    
    @NotNull
    private String address;

    @Size(min = 8, max = 8)
    @NotNull
    private String phoneNumber;

    private boolean isRush;
    
    private String comments;


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public boolean isRush() {
        return isRush;
    }
    public void setRush(boolean isRush) {
        this.isRush = isRush;
    }
    public String getComments() {
        return comments;
    }
    public void setComments(String comments) {
        this.comments = comments;
    }
    
}
