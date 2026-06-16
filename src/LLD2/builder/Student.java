package LLD2.builder;

public class Student
{
    private int id;
    private String name;
    private String universityName;
    private int gradYear;
    private int psp;
    private int age;
    private String phoneNumber;

    private Student(int id, String name, String universityName, int gradYear, int psp, int age, String phoneNumber)
    {
        this.id = id;
        this.name = name;
        this.universityName = universityName;
        this.gradYear = gradYear;
        this.psp = psp;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }
    public static Builder builder()
    {
        return new Builder();
    }

    @Override
    public String toString()
    {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", universityName='" + universityName + '\'' +
                ", gradYear=" + gradYear +
                ", psp=" + psp +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public static class Builder
    {
        private int id;
        private String name;
        private String universityName;
        private int gradYear;
        private int psp;
        private int age;
        private String phoneNumber;

        public Builder setId(int id)
        {
            this.id = id;
            return this;
        }
        public Builder setName(String name)
        {
            this.name = name;
            return this;
        }
        public Builder setUniversityName(String universityName)
        {
            this.universityName = universityName;
            return this;
        }
        public Builder setGradYear(int gradYear)
        {
            this.gradYear = gradYear;
            return this;
        }
        public Builder setPSP(int psp)
        {
            this.psp = psp;
            return this;
        }
        public Builder setAge(int age)
        {
            this.age = age;
            return this;
        }
        public Builder setPhoneNumber(String phoneNumber)
        {
            this.phoneNumber = phoneNumber;
            return this;
        }

        private void validate()
        {
            if(age < 21)
            {
                throw new InvalidAgeException();
            }
            if(gradYear > 2024)
            {
                throw new InvalidGradYearException();
            }
            if(name == null)
            {
                throw new InvalidNameException();
            }
        }
        public Student build()
        {
            validate();
            return new Student(this.id, this.name, this.universityName, this.gradYear, this.psp, this.age, this.phoneNumber);
        }
    }
}
//why Builder return type?
// so that when it's given to Builder object, like return from setId(), here since the same object is maintained,
//                   Student.builder()
//                  .setName("Harrish M")
//                  .setId(1)
//                  .setAge(24)
////                .setPSP()
////                .setPhoneNumber()
////                .setUniversityName()
//                  .setGradYear(2021)
// it holds all the data in Builder object and then it is sent for built() and validated and returned as Student object
// this.id represent Builder.id so it's sent neatly to the student class