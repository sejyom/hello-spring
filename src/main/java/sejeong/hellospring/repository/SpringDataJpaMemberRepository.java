package sejeong.hellospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sejeong.hellospring.domain.Member;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository { //인터페이스가 인터페이스를 받을 땐 extends 쓰긩

    //JPQL select m from Member m where m.name = ?
    @Override
    Optional<Member> findByName(String name);
//    Optional<Member> findByNameAndId(String name, Long id);
}
