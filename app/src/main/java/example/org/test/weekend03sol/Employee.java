package example.org.test.weekend03sol;

public class Employee {
    private String employeeName;
    private String employeeBirth;
    private String employeeWage;
    private String employeeHireDate;
    private String employeeImage;
    private int employeeId;

    public Employee(String employeeName, String employeeBirth, String employeeWage, String employeeHireDate, String employeeImage) {
        this.employeeName = employeeName;
        this.employeeBirth = employeeBirth;
        this.employeeWage = employeeWage;
        this.employeeHireDate = employeeHireDate;
        this.employeeImage = employeeImage;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeBirthDate() {
        return employeeBirth;
    }

    public void setEmployeeBirthDate(String employeeBirthDate) {
        employeeBirth = employeeBirthDate;
    }

    public String getEmployeeWage() {
        return employeeWage;
    }

    public void setEmployeeWage(String employeeWage) {
        this.employeeWage = employeeWage;
    }

    public String getEmployeeHireDate() {
        return employeeHireDate;
    }

    public void setEmployeeHireDate(String employeeHireDate) {
        this.employeeHireDate = employeeHireDate;
    }

    public String getEmployeeImage() {
        return employeeImage;
    }

    public void setEmployeeImage(String employeeImage) {
        this.employeeImage = employeeImage;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public Employee(String employeeName, String employeeBirthDate, String employeeWage, String employeeHireDate, String employeeImage, int employeeId) {
        this.employeeName = employeeName;
        this.employeeBirth = employeeBirthDate;
        this.employeeWage = employeeWage;
        this.employeeHireDate = employeeHireDate;
        this.employeeImage = employeeImage;
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeName='" + employeeName + '\'' +
                ", EmployeeBirthDate='" + employeeBirth + '\'' +
                ", employeeWage='" + employeeWage + '\'' +
                ", employeeHireDate='" + employeeHireDate + '\'' +
                ", employeeImage='" + employeeImage + '\'' +
                ", employeeId=" + employeeId +
                '}';
    }

    public Employee(){};

}
