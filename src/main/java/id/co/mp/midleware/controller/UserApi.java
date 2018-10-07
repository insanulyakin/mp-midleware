package id.co.mp.midleware.controller;

import id.co.mp.midleware.model.User;
import id.co.mp.midleware.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserApi {

    private final static Logger console = LoggerFactory.getLogger(UserApi.class);

    @Autowired
    private UserService service;

    @PostMapping("/list")
    public ResponseEntity<?> list() {
        List<User> users = service.list();
        return ResponseEntity.ok().body(users);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(
            @Valid @RequestBody User user
    ) {
        console.info("request params: {}", user);

        Map<String, Object> response = new HashMap<>();
        service.save(user);
        response.put("message", "berhasil simpan dataa");
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(
            @Valid @RequestBody User user
    ) {
        console.info("request params: {}", user);

        Map<String, Object> response = new HashMap<>();
        service.update(user);
        response.put("message", "berhasil update dataa");
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/passwd")
    public ResponseEntity<?> changePasswd(
            @Valid @RequestBody User user
    ) {
        console.info("request params: {}", user);

        Map<String, Object> response = new HashMap<>();
        service.changePasswd(user);
        response.put("message", "berhasil ubah passwd");
        return ResponseEntity.ok().body(response);
    }
}
