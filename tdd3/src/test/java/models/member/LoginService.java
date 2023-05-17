package models.member;

import validators.Validator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginService {

    private Validator<HttpServletRequest> validator;
    private MemberDao memberDao;

    public LoginService(MemberDao memberDao, Validator<HttpServletRequest> validtor) {
        this.memberDao = memberDao;
        this.validator = validtor;
    }

    public void login(HttpServletRequest request) {
        validator.check(request);

        /** 로그인 처리 */
        //HttpSession session = request.getSession();
        //session.setAttribute("member", member);
    }

}
