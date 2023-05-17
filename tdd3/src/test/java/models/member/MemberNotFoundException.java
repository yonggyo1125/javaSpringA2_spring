package models.member;

public class MemberNotFoundException extends RuntimeException {
    public MemberNotFoundException() {
        super("가입된 회원이 아닙니다.");
    }
}
