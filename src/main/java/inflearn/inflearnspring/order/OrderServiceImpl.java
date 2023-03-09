package inflearn.inflearnspring.order;

import inflearn.inflearnspring.discount.DiscountPolicy;
import inflearn.inflearnspring.discount.FixDiscountPolicy;
import inflearn.inflearnspring.member.Member;
import inflearn.inflearnspring.member.MemberRepository;
import inflearn.inflearnspring.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
