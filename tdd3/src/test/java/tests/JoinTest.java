package tests;

import models.member.JoinService;
import models.member.JoinValidationException;
import models.member.JoinValidator;
import models.member.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("회원가입 테스트")
public class JoinTest {

    private JoinService joinService;

    @BeforeEach
    void init() {
        JoinValidator validator = new JoinValidator();
        joinService = new JoinService(validator);
    }

    private Member getMember() {
        Member member = new Member();
        member.setUserId("user01");
        member.setUserPw("12345678");
        member.setUserPwRe(member.getUserPw());
        member.setUserNm("사용자01");

        return member;
    }

    @Test
    @DisplayName("회원가입 성공시 예외 발생 없음")
    void joinSuccessTest() {
        Member member = getMember();
        assertDoesNotThrow(() -> {
            joinService.join(member);
        });
    }

    @Test
    @DisplayName("필수 항목(userId, userPw, userPwRe, userNm) 검증, 실패시 JoinValidationException 발생")
    void requiredFieldsTest() {
        assertAll(
                // userId가 null
                () -> assertThrows(JoinValidationException.class, () -> {
                    Member member = getMember();
                    member.setUserId(null);
                    joinService.join(member);
                }),
                // userId가 공백 ...
                () -> assertThrows(JoinValidationException.class, () -> {
                    Member member = getMember();
                    member.setUserId("     ");
                    joinService.join(member);
                }),
                () -> assertThrows(JoinValidationException.class, () -> {
                    Member member = getMember();
                    member.setUserId(null);
                    joinService.join(member);
                }),
                // userPw가 null
                () -> assertThrows(JoinValidationException.class, () -> {
                    Member member = getMember();
                    member.setUserPw(null);
                    joinService.join(member);
                }),
                // userPw가 빈값
                () -> assertThrows(JoinValidationException.class, () -> {
                    Member member = getMember();
                    member.setUserPw("     ");
                    joinService.join(member);
                }),
                // userPwRe가 null
                () -> assertThrows(JoinValidationException.class, () -> {
                    Member member = getMember();
                    member.setUserPwRe(null);
                    joinService.join(member);
                }),
                // userPwRe가 빈값
                () -> assertThrows(JoinValidationException.class, () -> {
                    Member member = getMember();
                    member.setUserId("   ");
                    joinService.join(member);
                }),
                // userNm이 null
                () -> assertThrows(JoinValidationException.class, () -> {
                    Member member = getMember();
                    member.setUserNm(null);
                    joinService.join(member);
                }),
                // userNm이 빈값
                () -> assertThrows(JoinValidationException.class, () -> {
                    Member member = getMember();
                    member.setUserNm("       ");
                    joinService.join(member);
                })
        );
    }

}
