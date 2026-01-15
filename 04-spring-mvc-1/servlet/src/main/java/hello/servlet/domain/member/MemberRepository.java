package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 동시성 문제가 고려되어 있지 않음.
 * 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
 */
public class MemberRepository {

	private static Map<Long, Member> store = new HashMap<>();
	private static long sequence = 0L;

	// 1. 싱글톤, static 영역에 객체를 딱 1개만 생성해둔다.
	private static final MemberRepository instance = new MemberRepository();

	// 2. public으로 열어서 객체 인스턴스가 필요하면 이 static 메서드를 통해서만 조회 하도록 허용한다.
	public static MemberRepository getInstance() {
		return instance;
	}

	public Member save(Member member) {
		member.setId(++sequence);
		store.put(member.getId(), member);
		return member;
	}

	public Member findById(Long id) {
		return store.get(id);
	}

	public List<Member> findAll() {
		return new ArrayList<>(store.values());  // store의 값을 건드리지 않기 위해 ArrayList 사용
	}

	public void clearStore() {
		store.clear();
	}
}
