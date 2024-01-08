package alpha1.o.com.genericeventmgtsystem.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping
public class TestRolesController {
    ArrayList<String> user_roles_list = new ArrayList<>();
    public Map<String, String> roles = new HashMap<>();

    @GetMapping("/role/user")
    @PreAuthorize("hasRole('client_user') || hasRole('client_admin')")

    public ResponseEntity<Map<String, String>> hasUserRole() {
        user_roles_list.add("Admin");
        user_roles_list.add("user");
        roles.put("role", String.valueOf(user_roles_list));
        return (new ResponseEntity<>(roles, HttpStatus.OK));

    }
    @GetMapping("/role/super-admin")
    @PreAuthorize("hasRole('super_admin')")
    public ResponseEntity<Map<String, String>> hasAdminRole() {
        roles.put("role", "Super Admin");
        return (new ResponseEntity<>(roles, HttpStatus.OK));

    }
}
