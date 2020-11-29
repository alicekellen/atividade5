package com.uebp.apialunos.resources;

import com.uebp.apialunos.dto.JwtResponseDTO;
import com.uebp.apialunos.dto.UserAlunoDTO;
import com.uebp.apialunos.security.JwtTokenUtil;
import com.uebp.apialunos.service.JwtUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class JwtAuthController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService jwtService;

    @PostMapping("/authenticate")
    @ResponseBody
    public ResponseEntity<JwtResponseDTO> createAuthenticationToken(@RequestBody UserAlunoDTO authenticationRequest) throws Exception {        
        final UserDetails userDetails = jwtService.loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        
        return ResponseEntity.ok(new JwtResponseDTO(token));
    }
}