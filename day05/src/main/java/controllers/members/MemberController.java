package controllers.members;

import models.member.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Controller
@RequestMapping("/member")
public class MemberController {
    @GetMapping("/info")
    public String info(Model model) {
        Member member = new Member();
        member.setUserId("<h1>user01</h1>");
        member.setUserPw("123456");
        member.setUserNm("사용자01");
        member.setRegDt(LocalDateTime.now());

        model.addAttribute("member", member);

        return "member/info";
    }

    @GetMapping("/list")
    public String members(Model model) {
        List<Member> members = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            Member member = new Member();
            member.setUserId("user" + i);
            member.setUserNm("사용자" + i);
            member.setRegDt(LocalDateTime.now());
            members.add(member);
        }

        model.addAttribute("members", members);

        String[] addCss = { "member/style", "order/style" };
        List<String> addScript = Arrays.asList("member/form", "fileupload");

        model.addAttribute("addCss", addCss);
        model.addAttribute("addScript", addScript);

        return "member/list";
    }
}
