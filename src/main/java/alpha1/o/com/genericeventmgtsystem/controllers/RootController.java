package alpha1.o.com.genericeventmgtsystem.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping()
public class RootController {
    public Map<String, String> appRoot = new HashMap<>();

    @GetMapping("/")
    public ResponseEntity<Map<String, String>> hasUserRole() {
        appRoot.put("message", "Hi There , This is Home Page");
        appRoot.put("appName","Generic Event Management System");
        appRoot.put("end-point", "/");

        return (new ResponseEntity<>(appRoot, HttpStatus.OK));

    }

}
