package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {     //잘 작동하는지 테스트해보는 곳 (JUnit 테스트)

    MemberService memberService;

    @BeforeEach //테스트 실행 전 무조건 실행
    public void beforeEach(){
        AppConfig appconfig = new AppConfig();
        memberService = appconfig.memberService();
    }

    //테스트 작성 방법 !
    @Test
    void join(){
        //given

        Member member = new Member(1L,"memberA",Grade.VIP);
        //when

        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
