package tests;

import models.member.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@MockitoSettings(strictness = Strictness.WARN)
@ExtendWith(MockitoExtension.class)
public class LoginTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpSession session;

    private Member member;

    private LoginService loginService;

    @BeforeEach
    void init() {
        ServiceManager serviceManager = new ServiceManager();
        loginService = serviceManager.getLoginService();
        JoinService joinService = serviceManager.getJoinService();

        // 회원 가입
        if (member == null) {
            member = new Member();
            member.setUserId("user" + System.currentTimeMillis());
            member.setUserPw("12345678");
            member.setUserPwRe(member.getUserPw());
            member.setUserNm("사용자01");
            joinService.join(member);
        }
    }

    // 성공 데이터
    private void createCorrectData() {
        given(request.getParameter("userId")).willReturn(member.getUserId());
        given(request.getParameter("userPw")).willReturn(member.getUserPw());
    }

    private void createParamData(String userId, String userPw) {
        given(request.getParameter("userId")).willReturn(userId);
        given(request.getParameter("userPw")).willReturn(userPw);
    }
    
    @Test
    @DisplayName("로그인 성공시 예외 없음")
    void loginSuccessTest() {
        assertDoesNotThrow(() -> {
            createCorrectData();
            loginService.login(request);
        });
    }

    @Test
    @DisplayName("필수 항목(userId, userPw) 검증 - 실패시 LoginValidationException")
    void requiredFieldTest() {
        assertAll(
                // userId가 null
                () -> assertThrows(LoginValidationException.class, () -> {
                    createParamData(null, member.getUserPw());
                    loginService.login(request);
                }),
                // userId가 빈값
                () -> assertThrows(LoginValidationException.class, () -> {
                    createParamData("   ", member.getUserPw());
                    loginService.login(request);
                }),
                // userPw가 null
                () -> assertThrows(LoginValidationException.class, () -> {
                    createParamData(member.getUserId(), null);
                    loginService.login(request);
                }),
                // userPw가 빈값
                () -> assertThrows(LoginValidationException.class, () -> {
                    createParamData(member.getUserId(), "     ");
                    loginService.login(request);
                })
        );
    }

    @Test
    @DisplayName("userId로 조회된 회원이 없는 경우 MemberNotFoundException 발생")
    void memberExistsTest() {
        assertThrows(MemberNotFoundException.class, () -> {
            createParamData("user99", member.getUserPw());
            loginService.login(request);
        });
    }

    @Test
    @DisplayName("비밀번호가 일치하지 않으면 LoginValidationException 발생, 아이디 또는 비밀번호가 일치하지 않습니다.")
    void memberPasswordTest() {
        LoginValidationException thrown = assertThrows(LoginValidationException.class, () -> {
            createParamData(member.getUserId(), "12345");
            loginService.login(request);
        });
        String message = thrown.getMessage();
        assertTrue(message.contains("아이디 또는 비밀번호가 일치하지"));
    }
}

