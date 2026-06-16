package LLD1.lambdaAndStream;
@FunctionalInterface
//only one method in an interface is called functional interface
public interface Instructor <T>
{
    void teach(int noOfStudents, T batch); // by default all abstract methods in an interface are public,
    // since it needs to be used
}
