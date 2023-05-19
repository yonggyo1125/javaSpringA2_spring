package controllers;

import models.member.MemberJoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private JoinValidator joinValidator;

    @Autowired
    private Optional<MemberJoinService> opt;

    @GetMapping("/join")
    public String join(@ModelAttribute JoinForm joinForm) {
        /**
        JoinForm joinForm = new JoinForm();
        model.addAttribute("joinForm", joinForm);
        */
        return "member/join";
    }

    @PostMapping("/join")
    public String joinPs(@Valid JoinForm joinForm, Errors errors) {
        joinValidator.validate(joinForm, errors);

        if (errors.hasErrors()) {
            return "member/join";
        }

        // 회원가입 처리
        MemberJoinService joinService = opt.get();
        joinService.join(joinForm);


        return "redirect:/member/login";
    }

    @GetMapping("/login")
    public String login(@ModelAttribute LoginForm loginForm) {

        return "member/login";
    }

    @PostMapping("/login")
    public String loginPs(@Valid LoginForm loginForm, Errors errors) {

        if (errors.hasErrors()) {
            return "member/login";
        }


        return "redirect:/"; // 메인페이지
    }
}
