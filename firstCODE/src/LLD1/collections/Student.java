package LLD1.collections;
import java.util.Objects;
public class Student
{
    public int id;
    public String name;
    public Student(int id, String name)
    {
        this.id = id;
        this.name = name;
    }
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id; //&& Objects.equals(name, student.name);
    }
    @Override
    public int hashCode()
    {
        return Objects.hash(id, name); //this give the hashcode of the object
        //make it return Objects.hash(id); to get the hash value of id
    }
}

