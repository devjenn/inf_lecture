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
		store.put(member.getId(), member); //map�� ����
		return member;
	}
	
	@Override
	public Optional<Member> findById(Long id) {
		//id�� store���� ������ ��
		//null�� ���� ���ɼ��� �ִٸ�, Optional.ofNullable�� ���μ� ��ȯ
		return Optional.ofNullable(store.get(id));
	}
	
	@Override
	public Optional<Member> findByName(String name) {
		//�ڹ�8�� ���� ���
		return store.values().stream() //������ ���鼭
				
			// ����(���� ���) ������� member.getName�� �Ķ���ͷ� �Ѿ�� name�̶� ������ Ȯ��, ���� ��쿡�� ���͸�, ���߿��� ã���� ��ȯ��
			.filter(member -> member.getName().equals(name)) 
			.findAny();
		
		// ������ ���ȴµ� ������ Optional�� null�� ���Եż� ��ȯ��
	}
	
	@Override
	public List<Member> findAll() {
		//store�� �ִ� values(), �� Member���� ��ȯ��
		return new ArrayList<>(store.values()); 
	}
	
}
