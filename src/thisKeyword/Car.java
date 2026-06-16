package thisKeyword;
public class Car {
    public String make;
    public String model;
    public int year;
    public Car(String make, String model, int year)
    {
        this.make = make;
        this.model = model;
        this.year = year;
    }
    public Car(String make, String model)
    {
        this(make, model, 2024);
    }
    public Car(String make)
    {
        this(make, "Verna");
    }
}




