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
    private String name;
    private String address;
    private String phoneNumber;
    private boolean isRush;
    private String comments;
    
}
