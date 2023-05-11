package exam03.models.member;

import org.springframework.beans.factory.annotation.Autowired;

public class JoinService {

    @Autowired
    private JoinValidator validator;

    @Autowired
    private MemberDao memberDao;


    public void join(Member member) {
        validator.check(member);

        // 가입 처리
        memberDao.insert(member);

    }
}