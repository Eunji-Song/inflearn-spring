package inflearn.inflearnspring;

import inflearn.inflearnspring.member.Grade;
import inflearn.inflearnspring.member.Member;
import inflearn.inflearnspring.member.MemberService;
import inflearn.inflearnspring.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();

        Member memberA = new Member(1L, "memberA", Grade.VIP);
        memberService.join(memberA);

        Member member1 = memberService.findMember(1L);
        System.out.println("newMember = " + memberA.getName());
        System.out.println("findMember = " + member1.getName());
    }
}
