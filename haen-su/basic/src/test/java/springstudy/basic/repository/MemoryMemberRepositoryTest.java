package springstudy.basic.repository;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import springstudy.basic.domain.Member;
import springstudy.basic.repository.MemoryMemberRepository;

import java.util.List;


class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {

        // given
        Member member = new Member();
        member.setName("member1");

        //when
        repository.save(member);

        // then
        Member result = repository.findById(member.getId()).get();
        assertThat(result).isEqualTo(member);
    }

    @Test
    public void findById(){

        // given
        Member member1 = new Member();
        member1.setName("member1");
        repository.save(member1);
        Member member2 = new Member();
        member2.setName("member2");
        repository.save(member2);

        //when
        Member result = repository.findById(member1.getId()).get();

        // then
        assertThat(result).isEqualTo(member1);

    }

    @Test
    public void findByName() {
        // given
        Member member1 = new Member();
        member1.setName("member1");
        repository.save(member1);
        Member member2 = new Member();
        member2.setName("member2");
        repository.save(member2);

        //when
        Member result = repository.findByName(member1.getName()).get();

        // then
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        // given
        Member member1 = new Member();
        member1.setName("member1");
        repository.save(member1);
        Member member2 = new Member();
        member2.setName("member2");
        repository.save(member2);

        //when
        List<Member> result = repository.findAll();

        // then
        assertThat(result.size()).isEqualTo(2);
    }

}