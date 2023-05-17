package models.member;

import validators.Validator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginValidator implements Validator<HttpServletRequest> {

    private MemberDao memberDao;

    public LoginValidator(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Override
    public void check(HttpServletRequest request) {
        String userId = request.getParameter("userId");
        String userPw = request.getParameter("userPw");

        checkRequired(userId, new LoginValidationException("아이디를 입력하세요."));
        checkRequired(userPw, new LoginValidationException("비밀번호를 입력하세요."));

        /** 등록된 회원인지 체크 */
        Member member = memberDao.get(userId);

        if (member == null) {
            throw new MemberNotFoundException();
        }

        /** 비밀번호 일치 여부 */
        if (!userPw.equals(member.getUserPw())) {
            throw new LoginValidationException("아이디 또는 비밀번호가 일치하지 않습니다.");
        }


    }
}
