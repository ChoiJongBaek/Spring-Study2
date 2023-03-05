package hello.core.discount;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
// @Qualifier("mainDiscountPolicy")를 통해 @Autowired 시 중복된 빈이 조회될 경우 구분자 부여
//@Qualifier("mainDiscountPolicy")
// @Primary를 통해 @Autowired 시 중복된 빈이 조회될 경우 우선순위 부여
//@Primary
// 새로 생성한 MainDiscountPolicy 어노테이션을 이용
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {
            return price * discountPercent /100;
        } else {
            return 0;
        }
    }
}
