package exam03;

import exam03.models.member.JoinService;
import exam03.models.member.Member;
import exam03.models.member.MemberInfoService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import exam03.config.*;

import java.time.LocalDateTime;

public class Ex02 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx2.class);

        JoinService service = ctx.getBean(JoinService.class);
        MemberInfoService infoService = ctx.getBean("memberInfoService", MemberInfoService.class);

        Member member = new Member();
        member.setUserId("user01");
        member.setUserPw("12345678");
        member.setUserPwRe("12345678");
        member.setUserNm("사용자01");
        member.setRegDt(LocalDateTime.now());
        service.join(member);

        infoService.print(member.getUserId());

        ctx.close();
    }
}
