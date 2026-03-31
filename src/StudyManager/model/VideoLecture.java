package src.StudyManager.model;

public class VideoLecture extends StudyResource
{
    private String url;
    private int durationMinutes;

    public VideoLecture(String title, String subject, String url, int durationMinutes)
    {
        super(title, subject);
        this.url = url;
        this.durationMinutes = durationMinutes;
    }

    @Override
    public void displayDetails()
    {
        System.out.println("[VIDEO] " + getTitle() + " | Subject : " + getSubject());
        System.out.println("URL : " + url + " | Duration : " + durationMinutes + " mins");
        System.out.println("Status : " + (isCompleted() ? "Watched" : "To Watch"));
        System.out.println("---------------------------");
    }
}