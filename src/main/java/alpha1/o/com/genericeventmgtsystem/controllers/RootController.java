package alpha1.o.com.genericeventmgtsystem.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasRole('client_user')")
    public ResponseEntity<Map<String, String>> root() {
        appRoot.put("app-name", "generic-event-mgt-system");
        appRoot.put("end-point", "/");

        return (new ResponseEntity<>(appRoot, HttpStatus.OK));

    }
}
