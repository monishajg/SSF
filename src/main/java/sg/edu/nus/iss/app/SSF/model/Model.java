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

public class Model {
    // instance variables =====================================
    @NotNull(message="Name cannot be null")
    @Size(min=2, max=32, message="Name must be between 2 and 32 chars")
    private String name;

    @Email(message="Must be a valid email")
    private String email;

    private Boolean isMarried;
    
    @Min(value=10 , message="Age cannot be less than 10 years old")
    @Max(value=100, message="Age cannot be more than 100 years old")
    private Integer age;

    @Past(message="Cannot be future date")
    @NotNull(message="Date of birth must be mandatory")
    @DateTimeFormat(pattern="MM-dd-yyyy")
    private LocalDate dateOfBirth;

    @NotEmpty(message="Enter a hobby")
    @Size(min=1,message="Must be at least one hobby")
    private List<String> hobbies;

    @Min(value=1, message="Minimum quantity is 1")
    @Digits(integer=5, fraction=2, message="x quantity is 5 digits and 2 decimals")
    private Float quantity;
    //getter and setters ======================================
}