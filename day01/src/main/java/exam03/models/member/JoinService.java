package exam03.models.member;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class JoinService {

    @Autowired
    private JoinValidator validator;

    @Autowired
    private Optional<MemberDao> opt;


    public void join(Member member) {
        MemberDao memberDao = opt.get();
        validator.check(member);

        // 가입 처리
        memberDao.insert(member);

    }
}