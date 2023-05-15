package models.member;

import validators.Validator;

public class JoinValidator implements Validator<Member> {

    @Override
    public void check(Member member) {
        String userId = member.getUserId();
        String userPw = member.getUserPw();
        String userPwRe = member.getUserPwRe();
        String userNm = member.getUserNm();

        /** 필수 데이터 검증 S */
        checkRequired(userId, new JoinValidationException("아이디를 입력하세요."));
        checkRequired(userPw, new JoinValidationException("비밀번호를 입력하세요."));
        checkRequired(userPwRe, new JoinValidationException("비밀번호를 확인하세요."));
        checkRequired(userNm, new JoinValidationException("회원명을 입력하세요."));
        /** 필수 데이터 검증 E */

    }
}