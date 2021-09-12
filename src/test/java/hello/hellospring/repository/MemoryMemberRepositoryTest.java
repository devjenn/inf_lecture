package hello.hellospring.repository;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;


import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import hello.hellospring.domain.Member;

class MemoryMemberRepositoryTest {

MemoryMemberRepository repository = new MemoryMemberRepository();
	
	//메서드 한 동작이 끝날 때 마다 실행, 저장된 것을 지움
	@AfterEach
	public void afterEach() {
		repository.clearStore();
	}
	
	@Test
	public void save() {
		Member member = new Member();
		member.setName("spring");
		
		repository.save(member);
		
		Member result = repository.findById(member.getId()).get();
		
		//System.out.println("result = " + (result = member));
		
		Assertions.assertThat(member).isEqualTo(result);
		//assertThat(member).isEqualTo(result);

	}
	
	@Test
	public void findByName() {
		Member member1 = new Member();
		member1.setName("spring1");
		repository.save(member1);

		Member member2 = new Member();
		member2.setName("spring2");
		repository.save(member2);
		
		//정상 동작 확인
		Member result = repository.findByName("spring1").get();
		assertThat(result).isEqualTo(member1); 

//		다른 객체
//		assertThat(result).isEqualTo(member1); 
	}
	
	
	@Test
	public void findAll() {
		Member member1 = new Member();
		member1.setName("spring1");
		repository.save(member1);

		Member member2 = new Member();
		member2.setName("spring2");
		repository.save(member2);
		
		List<Member> result = repository.findAll();
		//정상 동작 확인
//		assertThat(result.size());
		assertThat(result.size()).isEqualTo(2);

//		다른 객체
//		assertThat(result).isEqualTo(member1); 
	}
}
