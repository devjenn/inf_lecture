package hello.hellospring.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import hello.hellospring.domain.Member;

public class MemoryMemberRepository implements MemberRepository {
	
	private static Map<Long, Member> store = new HashMap<>();
	private static long sequence = 0;
	
	@Override
	public Member save(Member member) {
		member.setId(++sequence);
		store.put(member.getId(), member); //map에 저장
		return member;
	}
	
	@Override
	public Optional<Member> findById(Long id) {
		//id는 store에서 꺼내면 됨
		//null이 나올 가능성이 있다면, Optional.ofNullable로 감싸서 반환
		return Optional.ofNullable(store.get(id));
	}
	
	@Override
	public Optional<Member> findByName(String name) {
		//자바8의 람다 사용
		return store.values().stream() //루프도 돌면서
				
			// 필터(람다 사용) 멤버에서 member.getName이 파라메터로 넘어온 name이랑 같은지 확인, 같은 경우에만 필터링, 그중에서 찾으면 반환됨
			.filter(member -> member.getName().equals(name)) 
			.findAny();
		
		// 끝까지 돌렸는데 없으면 Optional에 null이 포함돼서 반환됨
	}
	
	@Override
	public List<Member> findAll() {
		//store에 있는 values(), 즉 Member들이 반환됨
		return new ArrayList<>(store.values()); 
	}
	
}
