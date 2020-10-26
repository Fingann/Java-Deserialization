package com.example.deserialization.springdeserializationdemo;

import com.example.deserialization.springdeserializationdemo.Models.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

@RestController
public class UserApi {
    @PostMapping("profilePicture")
    public String profilePicture(HttpServletRequest request) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(request.getInputStream());
        User user = (User) objectInputStream.readObject();
        byte[] profilePictureBytes;
        String profilePicturePath = "pictures/" + user.getAvatarFileName();
        try {
            profilePictureBytes = Files.readAllBytes(Paths.get(profilePicturePath));
        } catch (IOException e) {
            return "No profile picture found!";
        }

        return  Base64.getEncoder().encodeToString(profilePictureBytes);
    }

    @PostMapping("listStatistics")
    public String listStatistics(HttpServletRequest request) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(request.getInputStream());
        User user = (User) objectInputStream.readObject();
        return user.listStatistics();
    }

    @PostMapping("garbagecollect")
    public String garbagecollect(HttpServletRequest request) throws IOException, ClassNotFoundException {
        System.gc();
        System.runFinalization();
        return "Scheduled Garbage Collector";
    }
}
