/**
 * Created by John on 5/16/2017.
 */
public class NutritionIXItem
{
    private String id;
    private String name;
    private String brand;

    private int calories;

    public NutritionIXItem(String id, String name, String brand, int calories)
    {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.calories = calories;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getBrand() { return brand; }
    public int getCalories() { return calories; }

    @Override
    public String toString()
    {
        return "ID: " + id + '\n' + "Name: " + name + '\n' + "Brand: " + brand + '\n' + "Calories: " + calories;
    }
}
