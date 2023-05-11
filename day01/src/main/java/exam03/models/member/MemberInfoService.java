package exam03.models.member;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberInfoService {

    @Autowired
    private MemberDao memberDao;

    public void print(String userId) {
        Member member = memberDao.get(userId);

        System.out.println(member);
    }

}
