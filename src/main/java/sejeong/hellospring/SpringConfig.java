package sejeong.hellospring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sejeong.hellospring.aop.TimeTraceAop;
import sejeong.hellospring.repository.*;
import sejeong.hellospring.service.MemberService;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration //구성
public class SpringConfig {

    private final MemberRepository memberRepository;
    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /*
    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }
    */

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

/*
    @Bean
    public TimeTraceAop timeTraceAop() {
        return new TimeTraceAop();
    }
*/

/*
    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }
*/

}
