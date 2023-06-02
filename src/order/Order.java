package order;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class Order {

    //장바구니 ArrayList 생성
    static ArrayList<Product> orderArrayList = new ArrayList<>();


    //////////////
    ////메소드/////
    //////////////

    //////////상품구매창///////////

    //상품선택 후 구매확인 창.
    static void checkOrder(Product product) throws InterruptedException {
        Etc.lineDiv();
        System.out.println("\"" + product.getName() + "  | W " + product.getPrice() + " | " + product.getDesc() + "\"\n" +
                "위 메뉴를 장바구니에 추가하시겠습니까?\n" +
                "1.  확인        2. 취소");
        int ans = MainPage.sc.nextInt();
        switch (ans) {
            case 1:
                Order.addOrder(product);
                Etc.lineDiv();
                System.out.println(product.getName() + "가 장바구니에 추가되었습니다.");
                MainPage.showIndex();
                break;
            case 2:
                System.out.println("주문이 취소되었습니다.");
                checkOrder(product);
                break;
            default:
                System.out.println("올바르지 않은 입력입니다. ");
                checkOrder(product);
        }

    }


    //////////장바구니////////////

    //장바구니에 상품 추가하기
    static void addOrder(Product product) {
        orderArrayList.add(product);
    }

    //장바구니 금액 합계 구하기
    static double getTotalPrice() {
        double total = 0;
        for (Product product : orderArrayList) {
            total += product.getPrice();
        }
        return total;
    }
    //장바구니 리스트 전부 출력하기
    static void getTotalProduct() {
        for (Product product : orderArrayList) {
            System.out.println(product.getName() + "  |  " + product.getPrice() + "  |  " + product.getDesc());
        }
    }

    //장바구니 확인 및 결제 분기
    static void showTotalOrder() throws InterruptedException {
        if (orderArrayList.isEmpty()) {
            System.out.println("장바구니가 비었습니다." +
                    "메뉴판으로 돌아갑니다.");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            MainPage.showIndex();

        } else {
            System.out.println(
                    "아래와 같이 주문하시겠습니까?\n\n" +
                            "[  Orders  ]");
            getTotalProduct();
            System.out.println(
                    "\n[  Total  ]\n" +
                            "W " + getTotalPrice() +
                            "\n1. 주문      2. 메뉴판");
            switch (MainPage.sc.nextInt()) {
                case 1:
                    //결제완료 창
                    payFinish();
                case 2:
                    //메뉴판으로
                    MainPage.showIndex();
            }
        }
    }

    //주문번호 멤버 및 초기화 메소드
    static private int orderNum = 1;
    static void resetOrderNum() {
        orderNum=1;
    }

    //최종 장바구니 결제.
    static void payFinish() throws InterruptedException {
        SellingSheet.addOrder(orderArrayList);
        orderArrayList.clear();
        Etc.lineDiv();
        System.out.println("" +
                "주문이 완료되었습니다!\n\n" +
                "대기번호는 [ " + orderNum + " ] 번 입니다.\n" +
                "(3초 후 메뉴판으로 돌아갑니다.)");
        orderNum++;
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        MainPage.showIndex();
    }
        //장바구니 비우기. 결제 취소.
    static void cancleOrder () {
        orderArrayList.clear();
        System.out.println("주문이 취소되었습니다. 메뉴판으로 돌아갑니다.");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}