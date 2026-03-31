package src.StudyManager.model;
import java.io.Serializable;

public abstract class StudyResource implements Serializable
{
    private String title;
    private String subject;
    private boolean isCompleted;

    public StudyResource(String title, String subject)
    {
        this.title = title;
        this.subject = subject;
        this.isCompleted = false;
    }

    public void markAsComplete() { this.isCompleted = true; }
    public String getTitle() { return title; }
    public String getSubject() { return subject; }
    public boolean isCompleted() { return isCompleted; }

    public abstract void displayDetails();
}