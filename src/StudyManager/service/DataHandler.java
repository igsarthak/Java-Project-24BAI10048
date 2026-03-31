package src.StudyManager.service;

import src.StudyManager.model.*;
import java.io.*;
import java.util.ArrayList;

public class DataHandler
{
    private static final String FILE_NAME = "data/study_data.ser";

    public static void saveData(ArrayList<StudyResource> list)
    {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME)))
        {
            oos.writeObject(list);
        }
        catch (IOException e)
        {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<StudyResource> loadData()
    {
        File file = new File(FILE_NAME);
        if (!file.exists()) return new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (ArrayList<StudyResource>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    // Logic to reset the file
    public static void deleteFile()
    {
        File file = new File(FILE_NAME);
        if (file.exists()) file.delete();
    }
}