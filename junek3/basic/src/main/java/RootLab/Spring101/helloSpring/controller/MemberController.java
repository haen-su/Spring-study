package RootLab.Spring101.helloSpring.controller;

import RootLab.Spring101.helloSpring.domain.Member;
import RootLab.Spring101.helloSpring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class MemberController {
	private final MemberService memberService;

	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	@GetMapping("/members/new")
	public String createForm(){
		return "members/createMemberForm";
	}

	@PostMapping("/members/new")
	public String createMember(@ModelAttribute MemberForm form){
		Member member = new Member();
		member.setName(form.getName());
		memberService.join(member);
		return "redirect:/";
	}

	@GetMapping("/members")
	public String memberList(Model model){
		List<Member> members = memberService.findMembers();
		model.addAttribute("members", members);
		return "members/memberList";
	}
}