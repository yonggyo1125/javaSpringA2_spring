package models.member;

import validators.Validator;

public class JoinService {

    private Validator validator;

    public JoinService(Validator validator) {
        this.validator = validator;
    }

    public void join(Member member) {
        validator.check(member);
    }
}
