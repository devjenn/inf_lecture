package hello.hellospring.repository;

import java.util.List;
import java.util.Optional;

import hello.hellospring.domain.Member;

public interface MemberRepository {
	
	// save : ����ҿ� ȸ������ �����ϴ� ���
	// findById�� findByName : ����ҿ� ����� id�� name�� �������� ���
	// findAll : ���ݱ��� ����� ��� ȸ�������� List�� ������

	// Optional�� �ڹ�8�� �� ���
	// findById�� findByName���� �����Ͱ� ������ null�� ��ȯ�Ǵµ�
	// ���򿡴� null�� �״�� ��ȯ���� �ʰ� Optional�� ��ȯ�ؼ� ��ȯ�ϴ� ����� ��ȣ��

		Member save(Member member); // ȸ���� �����ϸ� ����� ȸ���� ��ȯ��
		Optional<Member> findById(Long id);
		Optional<Member> findByName(String name);
		List<Member> findAll();

}
