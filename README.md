# kiosk-Prac

개인과제 키오스크 프로그램만들기
  : 자바 기초 개인과제로 제작하게 된 프로젝트. 
	기본적인 속성을 받아서 메뉴에서 상속받아 상품객체를 생성했다. 
	생성된 각 객체 장바구니 리스트에 추가하고 주문완료 혹은 주문 취소시에 릿스트를 비우는 식으로 기능 구현.
 
 
**배운점**

- arrayList활용
- <>Generic 개념, 활용법.
- 로직 구현 가능 영역 (클래스 내에서 바로는 안되고 선언만 된다. 메소드나 생성자 안에서만 로직구현 가능)
- Static 특징 및 메모리 동작
- 기타 마이너한 기능등
	- String.format(".3f", para)
	- 지역변수는 자동으로 초기화가 되지 않음. (인스턴스 변수는 자동으로 됨)


**공부해볼점**

- Static의 메모리동작 원리 + 어떻게 활용하는 게 좋은 코딩인지.
- Hashtable : 이를 활용한 조회시 시간복잡도가 상수라고 했다. N이 아니라 상수인 이유가 궁금하다.
- 다른 콜렉션들의 구조. 자료구조. (튜터님 추천해준 책)
- Stringbuiler, Stringbuffer : 다른 분의 코드리뷰를 보니 sout으로 계속 출력안하고, sb에 append해두다가 한번에 출력하는 방식이 있다고 했다.
