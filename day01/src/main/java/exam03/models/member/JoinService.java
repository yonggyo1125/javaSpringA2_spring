package exam03.models.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JoinService {

    @Autowired
    private JoinValidator validator;

    @Autowired
   // @Qualifier("mdao1")
    private Optional<MemberDao> opt;


    public void join(Member member) {
        MemberDao memberDao = opt.get();
        validator.check(member);

        // 가입 처리
        memberDao.insert(member);

    }
}