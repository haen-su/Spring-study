package RootLab.Spring101.helloSpring.repository;

import RootLab.Spring101.helloSpring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
	Optional<Member> findByName(String name);
}
