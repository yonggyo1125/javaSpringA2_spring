package tests;

import models.member.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("회원가입 테스트")
public class JoinTest {

    private JoinService joinService;

    @BeforeEach
    void init() {
        MemberDao memberDao = new MemberDao();
        JoinValidator validator = new JoinValidator();
        validator.setMemberDao(memberDao);

        joinService = new JoinService(memberDao, validator);
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
        member.setUserId("user99");
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

    @Test
    @DisplayName("아이디가 6자리 이상, 검증 실패 - JoinValidationException, 문구 - 아이디를 6자리 이상 입력하세요.")
    void userIdLengthCheckTest() {
        JoinValidationException thrown = assertThrows(JoinValidationException.class, () -> {
            Member member = getMember();
            member.setUserId("user");
            joinService.join(member);
        });

        String message = thrown.getMessage();
        assertTrue(message.contains("아이디를 6자리"));
    }
    
    @Test
    @DisplayName("비밀번호가 8자리 이상, 검증 실패 - JoinValidationException, 문구 - 비밀번호를 8자리 이상 입력하세요.")
    void userPwLengthCheckTest() {
        JoinValidationException thrown = assertThrows(JoinValidationException.class, () -> {
            Member member = getMember();
            member.setUserPw("1234");
            joinService.join(member);
        });

        String message = thrown.getMessage();
        assertTrue(message.contains("비밀번호를 8자리 이상"));
    }

    @Test
    @DisplayName("아이디 중복이 되면 DuplicateMemberException")
    void dupicateUserIdTest() {
        assertThrows(DuplicateMemberException.class, () -> {
            Member member = getMember();
            joinService.join(member);
            joinService.join(member);
        });
    }
}
