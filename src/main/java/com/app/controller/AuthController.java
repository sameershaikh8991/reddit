package com.app.controller;


import com.app.dto.RegisterRequestDto;
import com.app.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {


    private  final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody RegisterRequestDto requestDto) throws Exception {
        authService.signup(requestDto);
        return new ResponseEntity<>("Account activation email has been sent", HttpStatus.OK);
    }

    @GetMapping("/accountVerification/{token}")

    public ResponseEntity<String> verifyAccount(@PathVariable String token){
        authService.verifyAccount(token);
        return new ResponseEntity<>("user Account activated", HttpStatus.OK);
    }
}
