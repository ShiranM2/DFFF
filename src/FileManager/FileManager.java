package FileManager;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class FileManager<T> implements Serializable {

    private String filename;

    public FileManager(String filename) {
        this.filename = filename;
    }

    private boolean isFileExists() {
        File file = new File(filename);
        return file.exists();
    }

    public void write(Set<T> object) {
        try (FileOutputStream fos = new FileOutputStream(this.filename);
             ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            // Write the object to the stream and then flush
            oos.writeObject(object);
            oos.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
    public Set<T> read() {
        File file = new File(this.filename);
        if (!file.exists()) { // Return empty set when file is not exists
            return new HashSet<>();
        }
        if (file.exists() && file.length() > 0) {
            // Try-with-resources, one filestream and one objectstream
            try (FileInputStream fis = new FileInputStream(file);
                 ObjectInputStream ois = new ObjectInputStream(fis);) {
                // Return whatever object we read.
                return (Set<T>) ois.readObject();
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        return null;
        // If there is no file or nothing in it, return null.
    }

    public ArrayList<T> readlist() {
        File file = new File(this.filename);
        if (!file.exists()) { // Return empty set when file is not exists
            return new ArrayList<T>();
        }
        if (file.exists() && file.length() > 0) {
            // Try-with-resources, one filestream and one objectstream
            try (FileInputStream fis = new FileInputStream(file);
                 ObjectInputStream ois = new ObjectInputStream(fis);) {
                // Return whatever object we read.
                return (ArrayList<T>) ois.readObject();
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        return null;
        // If there is no file or nothing in it, return null.
    }


    public void write(ArrayList<T> object) {
        try (FileOutputStream fos = new FileOutputStream(this.filename);
             ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            // Write the object to the stream and then flush
            oos.writeObject(object);
            oos.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}