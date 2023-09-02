# 한 일
1. TotalFee 계산에 대한 책임을 screening -> reservation 변경 (Screening은 특정 시각에 상영하는 영화 객체이고 총 금액을 계산할 책임은 reservation 객체에 있고 reservation 객체의 내부 구현 중에 총 금액이 있기 때문에 캡슐화를 위해 변경함)
2. movie의 요금 정책을 여러개 겹처서 사용할 수 있도록 DiscountPolicy -> DiscountPolicy[] 로 변경
3. Test 작성
