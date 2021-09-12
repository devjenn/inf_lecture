package hello.hellospring.repository;

import java.util.List;
import java.util.Optional;

import hello.hellospring.domain.Member;

public interface MemberRepository {
	
	// save : 저장소에 회원정보 저장하는 기능
	// findById나 findByName : 저장소에 저장된 id나 name을 가져오는 기능
	// findAll : 지금까지 저장된 모든 회원정보를 List로 가져옴

	// Optional은 자바8에 들어간 기능
	// findById나 findByName에서 데이터가 없으면 null로 반환되는데
	// 요즘에는 null을 그대로 반환하지 않고 Optional로 변환해서 반환하는 방법을 선호함

		Member save(Member member); // 회원을 저장하면 저장된 회원이 반환됨
		Optional<Member> findById(Long id);
		Optional<Member> findByName(String name);
		List<Member> findAll();

}
