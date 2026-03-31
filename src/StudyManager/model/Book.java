package src.StudyManager.model;

public class Book extends StudyResource
{
    private String author;
    private int totalPages;

    public Book(String title, String subject, String author, int totalPages)
    {
        super(title, subject);
        this.author = author;
        this.totalPages = totalPages;
    }

    @Override
    public void displayDetails()
    {
        System.out.println("[Book] " + getTitle() + " | Subject : " + getSubject());
        System.out.println("Author : " + author + " | Pages : " + totalPages);
        System.out.println("Status : " + (isCompleted() ? "Finished" : "In Progress"));
        System.out.println("--------------------------");
    }
}
