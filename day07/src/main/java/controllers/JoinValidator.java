package controllers;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class JoinValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return JoinForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        JoinForm joinForm = (JoinForm) target;

        /**
         * 1. 아이디의 중복 여부 -> 이미 가입된 경우 X
         * 2. 비밀번호, 비밀번호 확인의 일치 여부
         */
        String userId = joinForm.getUserId();
        String userPw = joinForm.getUserPw();
        String userPwRe = joinForm.getUserPwRe();


        // 2. 비밀번호, 비밀번호 확인의 일치 여부
        if (userPw != null && !userPw.isBlank()
                && userPwRe != null && !userPwRe.isBlank() && !userPw.equals(userPwRe)) {
            errors.rejectValue("userPwRe", "Incorrect");
        }

        /** 필수 항목 체크 - userId, userPw, userPwRe, userNm */
        /**
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userId", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userPw", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userPwRe", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userNm", "required");
        */
        /**
        String userId = joinForm.getUserId();
        String userPw = joinForm.getUserPw();
        String userPwRe = joinForm.getUserPwRe();
        String userNm = joinForm.getUserNm();


        if (userId == null || userId.isBlank()) {
            errors.rejectValue("userId", "required", "아이디를 입력하세요.");
        }

        if (userPw == null || userPw.isBlank()) {
            errors.rejectValue("userPw", "required", "비밀번호를 입력하세요.");
        }

        if (userPwRe == null || userPwRe.isBlank()) {
            errors.rejectValue("userPwRe", "required", "비밀번호 확인 하세요.");
        }

        if (userNm == null || userNm.isBlank()) {
            errors.rejectValue("userNm", "required", "이름을 입력하세요.");
        }
         */
    }
}
