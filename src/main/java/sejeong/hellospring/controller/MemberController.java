package sejeong.hellospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import sejeong.hellospring.domain.Member;
import sejeong.hellospring.service.MemberService;

import java.util.List;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired //스프링 컨테이너에서 memberService를 가져옴
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) { //회원등록
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/"; //메인화면으로 돌림
    }

    @GetMapping("/members")
    public String list(Model model) { //회원조회
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
