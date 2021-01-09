package com.example.auth.service;

import com.example.auth.model.response.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private static final String BASE_URL = "http://127.0.0.1:8100";

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /*
         * TODO : RestTemplate 으로 Member Server에 username을 사용하여 Request하고 Response로 Member 객체를 리턴받는다.
         */

        /*
         * TODO : null에 Response로 받은 Member 객체의 Username 과 Password가 삽입된다.
         */
        return new User(null, null, new ArrayList<>());
    }


    /*
     * TODO : Register 구현 ( PasswordEncoder로 password를 Hash한 뒤 RestTemplate으로 member 서버에 데이터 전송 후 저장)
     */
    public ResponseEntity<Member> register(Member member) {
        /*member.setPassword(passwordEncoder.encode(member.getPassword() + member.getUsername()));*/

        /* NOTE : http://127.0.0.1:8100/member/sign-up */
        Member apiResponse = restTemplate.postForObject(BASE_URL + "/member/sign-up", member, Member.class);

        if (apiResponse != null) {
            return ResponseEntity.ok(apiResponse);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }
}
