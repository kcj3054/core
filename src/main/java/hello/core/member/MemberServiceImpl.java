package hello.core.member;

public class MemberServiceImpl implements MemberService{

    //추상화, 구체화 둘다에 의존한다 DIP를 위반하는 것이다.
    private MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memoryMemberRepository) {
        this.memberRepository = memoryMemberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
