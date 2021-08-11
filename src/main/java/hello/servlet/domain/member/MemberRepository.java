package hello.servlet.domain.member;

// 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려함
// HashMap 그대로 사용하지 않음

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    private static final MemberRepository instance = new MemberRepository(); //싱글톤 패턴 적용을 위한 final
    public static MemberRepository getInstance(){
        return instance;

    }
    private MemberRepository(){

    }
    public Member save(Member member){
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;

    }

    public Member findById(Long id){
        return store.get(id); //아이디로 조회
    }

    public List<Member> findAll(){
        return new ArrayList<>(store.values()); //새로 배열에 담아서 리턴해줌
    }

    public void clearStore(){
        store.clear();
    }

}
