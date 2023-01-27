package sg.edu.nus.iss.app.SSF.model;

import java.util.Random;

import jakarta.json.Json;
import jakarta.json.JsonObject;
//  Validation(wrkshp13,14)
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Pizza {
    // Task 2 =====================================
    @Size(max = 1)
    @NotNull(message = "Please select type of pizza")
    private String type;

    @NotNull(message = "Please select the pizza size")
    private String size;

    @Min(value=1, message = "Minimum order of 1")
    @Max(value=11, message = "Maximum order is 10")
    @NotNull(message = "Please indicate number of pizzas")
    private int number;

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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    // Task 3 =====================================
    @Size(min =3)
    @NotNull
    private String name;
    
    @NotNull
    private String address;

    @Size(min = 8, max = 9)
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

    // Task 3 (a.) =====================================
    private String id;
    
    public synchronized String generateId(int numChars) {
        Random r = new Random();
        StringBuilder strBuilder = new StringBuilder();
        while (strBuilder.length() < numChars) {
            strBuilder.append(Integer.toHexString(r.nextInt()));
        }
        return strBuilder.toString().substring(0, numChars);
    }
    
    // ALL PIZZA =====================================
    public Pizza pizzaOrder() {
        this.id = generateId(8);
    }
    
    public Pizza pizzaOrder(String type, String size, int number) {
        this.type = type;
        this.size = size;
        this.number = number;
    }

    public Pizza pizzaOrder(String id, String name, String address, String phoneNumber,
                    Boolean isRush, String comments, String type, String size, int number, int totalCost) {
        this.id = generateId(8);
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.isRush = isRush;
        this.comments = comments;
        this.type = type;
        this.size = size;
        this.number = number;
        this.totalCost = totalCost;
    }
    public JsonObject toJSON() {
        return Json.createObjectBuilder()
                .add("type", this.getType())
                .add("size", this.getSize())
                .add("number", this.getNumber())
                .add("name", this.getName())
                .add("address", this.getAddress())
                .add("phoneNumber", this.getPhoneNumber())
                .add("isRush", this.isRush())
                .add("comments", this.getComments())
                .add("cost", this.getCost())
                .add("totalCost", this.getTotalCost())
                .build();
    }

    public
    // Task 3 (b.) =====================================
    private double cost;
    private double totalCost;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public void Order (String type, String size, boolean isRush) {
        this.type = type;
        this.size = size;
        this.isRush = isRush;
        calculateTotalCost();
    }

    public void setPizzaType(String type) {
        this.type = type;
        calculateTotalCost();
    }

    public void setPizzaSize(String size) {
        this.size = size;
        calculateTotalCost();
    }

    public void setRushed(boolean rushed) {
        isRush = true;
        calculateTotalCost();
    }

    public double getTotalCost() {
        return totalCost;
    }

    private void calculateTotalCost() {
        double basePrice = 0;
        double sizeMultiplier = 1;
        double rushCharge = isRush ? 2 : 0;

        switch (type) {
            case "bella":
            case "marinara":
            case "spianatacalabrese":
                basePrice = 30;
                break;
            case "margherita":
                basePrice = 22;
                break;
            case "trioformaggio":
                basePrice = 25;
                break;
            default:
                System.out.println("Invalid pizza type.");
                break;
        }

        switch (size) {
            case "sm":
                sizeMultiplier = 1;
                break;
            case "md":
                sizeMultiplier = 1.2;
                break;
            case "lg":
                sizeMultiplier = 1.5;
                break;
            default:
                System.out.println("Invalid pizza size.");
                break;
        }
        cost = (basePrice * sizeMultiplier);
        totalCost = (basePrice * sizeMultiplier) + rushCharge;
    }
}