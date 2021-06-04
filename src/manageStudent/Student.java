package manageStudent;

import java.time.LocalDate;
import java.util.Date;

public class Student {
    private String id;
    private String name;
    private String dateOfBirth;
    private String address;
    private String email;
    private double score;

    public Student(String id, String name, String dateOfBirth, String address, String email, double score) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.email = email;
        this.score = score;
    }

    public Student() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getAge(){
        String[] dateOfBrith = getDateOfBirth().split("-");
        int age = LocalDate.now().getYear() - Integer.parseInt(dateOfBrith[2]);
        return age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + getAge() +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", score=" + score +
                '}';
    }
}
