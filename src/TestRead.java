import java.io.*;
import java.nio.file.Path;
import java.util.Objects;

public class TestRead {

    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("mine.ser");
             ObjectInputStream ois = new ObjectInputStream(fis)){


            // Deserialization or Reconstituting an Object

            // Must be cast into the correct type
            // • Can use instanceof
            //• allows you to check if object is an instance of a specific class
            // • ...but try to avoid this!


            // ObjectInputStream allow for writing multiple object consecutively into the stream.
            // Read them in the same order they were written.
            while(true){
                Object object = ois.readObject();
                if (object instanceof String) {
                    System.out.println("String: " + object);
                } else if (object instanceof Person){
                    System.out.println((Person) object);
                } else if (object instanceof Integer){
                    System.out.println(object);
                }
            }

        } catch (EOFException e) {
            // End of file exception
            System.out.println();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }
}