package com.beisi.controller;

import com.beisi.model.LoginRequest;
import com.beisi.model.LoginResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class LoginController {

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        LoginResponse response = new LoginResponse();
        
        // 硬编码的用户名和密码
        String hardcodedUsername = "admin";
        String hardcodedPassword = "123456";
        
        if (hardcodedUsername.equals(request.getUsername()) && hardcodedPassword.equals(request.getPassword())) {
            // 登录成功，生成模拟 token
            String token = UUID.randomUUID().toString();
            LoginResponse.Data data = new LoginResponse.Data();
            data.setToken(token);
            response.setCode(0);
            response.setMessage("Login successful");
            response.setData(data);
        } else {
            // 登录失败
            response.setCode(1);
            response.setMessage("Invalid username or password");
            response.setData(null);
        }
        
        return response;
    }
}