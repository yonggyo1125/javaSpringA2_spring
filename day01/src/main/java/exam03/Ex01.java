package exam03;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import exam03.config.*;
import exam03.models.member.*;

public class Ex01 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        JoinService service = ctx.getBean("joinService", JoinService.class);
        MemberDao memberDao = ctx.getBean("memberDao", MemberDao.class);

        Member member = new Member();
        member.setUserId("user01");
        member.setUserPw("12345678");
        member.setUserPwRe("12345678");
        member.setUserNm("사용자01");
        service.join(member);

        Member joinedMember = memberDao.get(member.getUserId());
        System.out.println(joinedMember);


        ctx.close();
    }
}
