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

public class Pizza {
    // instance variables =====================================
    @Size(max = 1)
    @NotNull(message = "Please select type of pizza")
    private String type;

    @NotNull(message = "Please select the pizza size")
    private String size;

    @Min(value=1, message = "Minimum order of 1")
    @Max(value=10, message = "Maximum order is 10")
    @NotNull(message = "Please indicate number of pizzas")
    private int number;
    
    //getter and setters ======================================
    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (type.equals("bella") || type.equals("margherita") || type.equals("marinara") || type.equals("spianatacalabrese") || type.equals("trioformaggio")) {
            this.type = type;
        }
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        if (size.equals("sm") || size.equals("md") || size.equals("lg")) {
            this.size = size;
        }
    }

    public int getQuantity() {
        return number;
    }

    public void setQuantity(int quantity) {
        this.number = quantity;
    }
}