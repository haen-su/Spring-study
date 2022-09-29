package RootLab.Spring101.helloSpring;

import RootLab.Spring101.helloSpring.aop.TimeTraceAop;
import RootLab.Spring101.helloSpring.repository.*;
import RootLab.Spring101.helloSpring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

	private final MemberRepository memberRepository;

	@Autowired
	public SpringConfig(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository);
	}

	/* JPA 적용하기
	private final EntityManager em;

	public SpringConfig(EntityManager em) {
		this.em = em;
	}

	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository());
	}

	@Bean
	public MemberRepository memberRepository() {
		return new JpaMemberRepository(em);
	}
	 */

}