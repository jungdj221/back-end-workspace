package com.kh.step5;

import com.kh.step5.model.Book;

public class Application {

	public static void main(String[] args) {
		Book b = new Book();
		
		
		b.setTitle("처음부터 시작하는 주식투자 단타전략"); // b.title = "처음부터 시작하는...";
		b.setAuthor("홍인기");
		b.setPrice(21000);
		b.setDiscountRate(0.2);
		
		Book b2 = new Book("나는 메트로폴리탄 미술관의 경비원입니다.", 17500, 0.1, "패트릭 브링리");
		
		// getter를 이용해서 두 객체 각각 할인율을 적용한 책 가격을 계산해서 제목과 같이 출력
		// 책의 제목과 함께 원래 가격과 할인된 가격 = 가격 - (가격 * 할인율)을 같이 출력
		int discount = (int) (b2.getPrice() - b2.getPrice()*b2.getDiscountRate());
		// 윗처럼 하면(b2) double이 아닌 int형 으로 잘 출력됨
		System.out.println(b.getTitle() + "의 원래가격은 " + b.getPrice()+"원이고, 할인된 가격은 " + (b.getPrice()- (b.getPrice()*b.getDiscountRate()) + "원입니다"));
		System.out.println(b2.getTitle() + "의 원래가격은 " + b2.getPrice() + "원이고, 할인된 가격은 " + discount + "원입니다.");
		
		
		
	}

}
