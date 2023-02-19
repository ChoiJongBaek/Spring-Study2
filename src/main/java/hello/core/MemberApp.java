package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        //@Configuration이 붙은설정정보를 스프링 컨테이너에서 관리해준다.
        //@Bean이 적힌 메서드를 모두 호출하여 반환된 객체를 스프링 컨테이너에 등록한다. -> 스프링 컨테이너에 등록된 객체 : 스프링 빈
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + findMember.getName());
        System.out.println("find Member = " + member.getName());
    }
}
