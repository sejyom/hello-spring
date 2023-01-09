package sejeong.hellospring.repository;

import sejeong.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); // 저장소에 저장
    Optional<Member> findById(Long id); // 아이디 반환
    Optional<Member> findByName(String name); // 이름 반환
    List<Member> findAll(); // 모든 회원 리스트 반환
}
