
public class Human {
    // Attributes of a Human

    private String name;
    private int age;
    private String gender;

    // Constructor to initialize Human attributes (will call by super keyword)
    public Human(int age, String name, String gender) {
        this.age = age;
        this.name = name;
        this.gender = gender;
    }

    //setter fn for age
    public void setAge(int age) {
        this.age = age;
    }
    //setter fn for name
    public void setName(String name) {
        this.name = name;
    }
    //setter fn for gender
    public void setGender(String gender){
        this.gender=gender;
    }

    // Getter fn for age
    public int getAge() {
        return age;
    }

    // Method to update Human information
    public void update(int age, String name, String gender) {
        this.age = age;
        this.name = name;
        this.gender = gender;
    }
}
