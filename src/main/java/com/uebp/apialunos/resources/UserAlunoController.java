package com.uebp.apialunos.resources;

import com.uebp.apialunos.dto.UserAlunoDTO;
import com.uebp.apialunos.models.UserAluno;
import com.uebp.apialunos.repository.UserAlunoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@CrossOrigin
public class UserAlunoController {

    @Autowired
    private UserAlunoRepository userAlunoRepository;

    @PostMapping("/signup")
    @ResponseBody
    public ResponseEntity<UserAluno> createUser(@RequestBody UserAlunoDTO user) {
        try {
            return ResponseEntity.ok(
                userAlunoRepository.save(new UserAluno(user.getEmail(), user.getUsername(), user.getPassword())));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}