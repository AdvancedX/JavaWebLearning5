package JBean;

// JBean.Grade.java
public class Grade {
    private int id;
    private int userId; // Foreign key referencing the users table
    private String subject;
    private int score;

    // Constructors, getters, setters, toString, etc.

    // Example of a constructor
    public Grade(int id, int userId, String subject, int score) {
        this.id = id;
        this.userId = userId;
        this.subject = subject;
        this.score = score;
    }

    // Example of a getter
    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getSubject() {
        return subject;
    }

    public int getScore() {
        return score;
    }

    // Example of a setter
    public void setId(int id) {
        this.id = id;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
