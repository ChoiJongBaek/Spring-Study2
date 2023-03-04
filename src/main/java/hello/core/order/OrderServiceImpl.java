package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor // final이 붙은 매개변수를 받는 생성자를 만들어준다.
public class OrderServiceImpl implements OrderService {

    // 생성자 주입을 사용할 경우 final 키워드를 사용할 수 있다.
    // final 키워드의 장점 : 생성할 때 정해지면 바뀌지가 않는다.
    // final 키워드를 주면 초기에 값을 생성하거나 생성자를 통해서만 값을 넣어줄 수 있다.
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    // @Qualifier("mainDiscountPolicy")를 통해 해당 구분자 빈을 조회
//    public OrderServiceImpl(MemberRepository memberRepository, @Qualifier("mainDiscountPolicy") DiscountPolicy discountPolicy) {

    // 위에 @RequiredArgsConstructor 어노테이션으로 인행 해당 생성자는 자동 생성
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
