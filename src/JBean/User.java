package JBean;

// JBean.User.java
public class User {
    private int id;
    private String name;
    private String gender;
    private String password;
    private String major;
    private String clazz; // Using "clazz" instead of "class" as "class" is a reserved keyword in Java
    private String studentId;
    private String introduction;

    // Constructors, getters, setters, toString, etc.

    // Example of a constructor
    public User(int id, String name, String gender, String password, String major, String clazz, String studentId, String introduction) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.password = password;
        this.major = major;
        this.clazz = clazz;
        this.studentId = studentId;
        this.introduction = introduction;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getPassword() {
        return password;
    }

    public String getMajor() {
        return major;
    }

    public String getClazz() {
        return clazz;
    }

    public String getStudentId(){
        return studentId;
    }

    public String getIntroduction(){
        return introduction;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
