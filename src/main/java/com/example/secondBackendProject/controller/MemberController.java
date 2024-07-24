package com.example.secondBackendProject.controller;

import com.example.secondBackendProject.dto.MemberForm;
import com.example.secondBackendProject.entity.Member;
import com.example.secondBackendProject.repository.MemberRepository;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Slf4j
@Controller
public class MemberController {

    @Autowired
    MemberRepository memberRepository;

    @GetMapping("/member/new")
    public String newMemberForm(Model model){
        return "members/new";
    }

    @PostMapping("/join")
    public String createMember(MemberForm member)
    {
        log.info(member.toString());
        Member memberEntity = member.toEntity(member);
        log.info(memberEntity.toString());
        Member saved = memberRepository.save(memberEntity);
        log.info(saved.toString());

        return "";
    }


    @GetMapping("/members/{id}")
    public String show(@PathVariable Long id, Model model){
        Member memberEntity = memberRepository.findById(id).orElse(null);
        model.addAttribute("member", memberEntity);
        return "members/show";
    }


    @GetMapping("/members")
    public String index(Model model)
    {
        List<Member> memberList = memberRepository.findAll();
        model.addAttribute("memberList", memberList);
        return "members/index";
    }

}
