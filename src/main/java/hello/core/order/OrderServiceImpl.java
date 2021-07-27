package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor //final 필드에 대한 생성자 만들어줌
public class OrderServiceImpl implements OrderService{

    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    //private  final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private final DiscountPolicy discountPolicy; //private final 불변, 필수 객체
    private final MemberRepository memberRepository;

    /* 선택, 변경 가능성이 있는 의존관계
    @Autowired(required = false) => 주입 대상이 없어도 동작
    public void setDiscountPolicy(DiscountPolicy discountPolicy){
        System.out.println("2.discountPolicy = " + discountPolicy);
        this.discountPolicy = discountPolicy;
    }

    @Autowired
    public void setMemberRepository(MemberRepository memberRepository){
        System.out.println("2.memberRepository = " + memberRepository);
        this.memberRepository = memberRepository;
    }
    */

    //생성자가 하나면 autowired 자동 주입
    //public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
    //    this.discountPolicy = discountPolicy;
    //    this.memberRepository = memberRepository;
    //    System.out.println("1.OrderServiceImpl.OrderServiceImpl");
    //}

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }

}
