import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class TestWrite {

    public static void main(String[] args) {

        // Java的序列化是一个用于将对象的状态转换为字节流的过程，这样就可以轻松地保存到磁盘上
        // 磁盘是无法保存对象的（非字节流的数据结构），他能保存字节流，但是序列化就是把对象转换为字节流，然后保存在磁盘上(或者通过网络传输到另一个系统）
        // 序列化在远程方法调用（RMI）、Java Beans和网络通信等多种场景中非常重要。
        // Serializaion:
        // The process of translating a data structure or object, into a format that can be stored on a file
        // Only instances of Serializable classes can be serialized!
        // Serializable interface doesn't have any methods, it's just used to mark the class as serializable.

        // 和前端交互一般使用json。 .ser只适用于java平台内部的对象序列化，比如java应用程序之间进行对象的持久化和运输。


        Integer i = 1234567;
        String str = "Hello World";
        Person personMichael = new Person("Michael Torpey", 1);
        Person personWhilliam = new Person("Whilliam T", 2);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("mine.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            // objectOutputStream allows for writing multiple objects consecutively into the same stream.
            // When reading these object back, simply use readObject(readInt...) method in the same order they were written.
            objectOutputStream.writeObject(i);
            objectOutputStream.writeObject(str);
            objectOutputStream.writeObject(personMichael);
            objectOutputStream.writeObject(personWhilliam);
            objectOutputStream.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}