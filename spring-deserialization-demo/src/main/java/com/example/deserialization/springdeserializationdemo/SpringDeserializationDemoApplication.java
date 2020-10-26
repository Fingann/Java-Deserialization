package com.example.deserialization.springdeserializationdemo;

import com.example.deserialization.springdeserializationdemo.Models.BoardState;
import org.apache.commons.compress.utils.IOUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
it remote set-
import java.io.*;

@SpringBootApplication
public class SpringDeserializationDemoApplication {


    public static void main(String[] args) throws Throwable {
        SpringApplication.run(SpringDeserializationDemoApplication.class, args);

        /*String employeePath = "SerializedClasses/Employee_Serialized";

        Employee employee = new Employee("peter",60 );

       //Serializing the user object
        SerializeObject(employee, employeePath);

        DeserializeFile(employeePath);



        //////////////////// Example 1 ////////////////////

        String userPath = "SerializedClasses/User_Serialized";

        // Creating a legitimate user object
        User user = new User("Peter","peter225.jpeg");

        //Serializing the user object
        SerializeObject(user, userPath);


        // Deserialize the stored Serialized Object
        User recievedUser = (User) DeserializeFile(userPath);



        System.out.println("User " + recievedUser.getUsername()+
                "'s avatar picture is located at: " + recievedUser.getAvatarFileName());

        //////////////////// Example 2 ////////////////////
        String adminUserPath = "SerializedClasses/AdminUser_Serialized";

        AdminUser adminUser = new AdminUser("Peter","peter225.jpeg");

        //Serializing the adminUser object
         SerializeObject(adminUser, adminUserPath);

        User recievedUser2 = (User) DeserializeFile(adminUserPath);

        System.out.println(recievedUser.getUsername() + "'s statistics are: "+recievedUser2.listStatistics());
*/
        //////////////////// Example 3 ////////////////////
        String boardStatePath = "SerializedClasses/BoardState_Serialized";
        byte[] bytes = IOUtils.toByteArray(new FileInputStream("SerializedClasses/application"));
        BoardState state = new BoardState("1001", bytes);

        //Serializing the boardState object
        SerializeObject(state, boardStatePath);


        // Ask garbage collector to run




        //////////////////// Example 4 ////////////////////
    }

    public static void SerializeObject(Object object, String filePath) throws IOException {
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath));
        outputStream.writeObject(object);
    }

    public static Object DeserializeFile(String filePath) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(filePath)));
        return ois.readObject();

    }

    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }
}

