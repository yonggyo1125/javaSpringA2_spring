package controllers;

import lombok.Data;

import java.util.List;

@Data
public class JoinForm {
    private String userId; // 아이디
    private String userPw; // 비밀번호
    private String userPwRe; // 비밀번호 확인
    private String userNm; // 사용자명
    private boolean agree; // 약관 동의

    private Address address;

    private List<String> hobby;
}
