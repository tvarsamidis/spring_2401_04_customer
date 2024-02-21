package gr.majestic.reservations.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class SessionController {


    @GetMapping("/set-session/user/{userName}")
    public String setSessionAttribute(HttpSession session, @PathVariable(name="userName") String userName) {
        session.setAttribute(userName, LocalDateTime.now().toString());
        return "Session attribute set";
    }

    @GetMapping("/get-session/user/{userName}")
    public String getSessionAttribute(HttpSession session, @PathVariable(name="userName") String userName) {
        String timeStamp = (String) session.getAttribute(userName);
        return "Session attribute value: " + timeStamp;
    }

}
