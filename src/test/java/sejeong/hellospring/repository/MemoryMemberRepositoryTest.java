package sejeong.hellospring.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import sejeong.hellospring.domain.Member;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach // 테스트 메서드 실행 후에 무조건 실행
    public void afterEach() {
        repository.clearStore(); // 각 테스트가 끝나면 데이터를 클리어해줌
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("sejeong");

        repository.save(member);
        Member result = repository.findById(member.getId()).get(); // Optional 타입에서 값 가져올 때 get() 쓰세여

        // 검증
        //Assertions.assertEquals(result, member); // 두 객체의 값이 같은지
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("sejeong1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("sejeong2");
        repository.save(member2);

        Member result = repository.findByName("sejeong1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("sejeong");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("sejeong2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        //비교
        assertThat(result.size()).isEqualTo(2);
    }
}