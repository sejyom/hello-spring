package sejeong.hellospring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sejeong.hellospring.repository.JdbcTemplateMemberRepository;
import sejeong.hellospring.repository.MemberRepository;
import sejeong.hellospring.repository.MemoryMemberRepository;
import sejeong.hellospring.service.MemberService;

import javax.sql.DataSource;

@Configuration //구성
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
        return new JdbcTemplateMemberRepository(dataSource);
    }
}
