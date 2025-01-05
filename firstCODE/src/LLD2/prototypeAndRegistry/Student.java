package LLD2.prototypeAndRegistry;

public class Student implements Prototype
{
    private String name;
    private String email;
    private String phoneNumber;
    private String yearOfEnrollment;
    private String batchName;
    private String moduleName;
    private String instructorName;
    private String moduleStartDate;
    private String moduleSchedule;
    private String moduleEndDate;

    public Student(String yearOfEnrollment, String batchName, String moduleName, String instructorName, String moduleStartDate, String moduleSchedule, String moduleEndDate)
    {
        this.yearOfEnrollment = yearOfEnrollment;
        this.batchName = batchName;
        this.moduleName = moduleName;
        this.instructorName = instructorName;
        this.moduleStartDate = moduleStartDate;
        this.moduleSchedule = moduleSchedule;
        this.moduleEndDate = moduleEndDate;
    }
    public Student(Student stud) // working as a copy constructor, and can be used to create deep copies for fixed attributes
    {
        this.yearOfEnrollment = stud.yearOfEnrollment;
        this.batchName = stud.batchName;
        this.moduleName = stud.moduleName;
        this.instructorName = stud.instructorName;
        this.moduleStartDate = stud.moduleStartDate;
        this.moduleSchedule = stud.moduleSchedule;
        this.moduleEndDate = stud.moduleEndDate;
    }

    @Override
    public String toString()
    {
        return "Student{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", yearOfEnrollment='" + yearOfEnrollment + '\'' +
                ", batchName='" + batchName + '\'' +
                ", moduleName='" + moduleName + '\'' +
                ", instructorName='" + instructorName + '\'' +
                ", moduleStartDate='" + moduleStartDate + '\'' +
                ", moduleSchedule='" + moduleSchedule + '\'' +
                ", moduleEndDate='" + moduleEndDate + '\'' +
                '}';
    }

    @Override
    public Student clone()
    {
        return new Student(this);
    }

    //getter
    public String getName()
    {
        return this.name;
    }
    public String getEmail()
    {
        return this.email;
    }
    public String getPhoneNumber()
    {
        return this.phoneNumber;
    }
    public String getYearOfEnrollment()
    {
        return this.yearOfEnrollment;
    }
    public String getBatchName()
    {
        return this.batchName;
    }
    public String getModuleName()
    {
        return this.moduleName;
    }
    public String getInstructorName()
    {
        return this.instructorName;
    }
    public String getModuleStartDate()
    {
        return this.moduleStartDate;
    }
    public String getModuleSchedule()
    {
        return this.moduleSchedule;
    }
    public String getModuleEndDate()
    {
        return this.moduleEndDate;
    }
    //setter
    public void setName(String name)
    {
        this.name = name;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }
    public void setYearOfEnrollment(String yearOfEnrollment)
    {
        this.yearOfEnrollment = yearOfEnrollment;
    }
    public void setBatchName(String batchName)
    {
        this.batchName = batchName;
    }
    public void setModuleName(String moduleName)
    {
        this.moduleName = moduleName;
    }
    public void setInstructorName(String instructorName)
    {
        this.instructorName = instructorName;
    }
    public void setModuleStartDate(String moduleStartDate)
    {
        this.moduleStartDate = moduleStartDate;
    }
    public void setModuleSchedule(String moduleSchedule)
    {
        this.moduleSchedule = moduleSchedule;
    }
    public void setModuleEndDate(String moduleEndDate)
    {
        this.moduleEndDate = moduleEndDate;
    }
}
