package exam03.models.member;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.format.DateTimeFormatter;

public class MemberInfoService {

    @Autowired
    private MemberDao memberDao;

    private DateTimeFormatter formatter;

    @Autowired
    public void setFormatter(DateTimeFormatter formatter) {
        this.formatter = formatter;
    }

    public void print(String userId) {
        Member member = memberDao.get(userId);

        System.out.println(member);
        if (formatter != null) {
            System.out.println(formatter.format(member.getRegDt()));
        }
    }

}
