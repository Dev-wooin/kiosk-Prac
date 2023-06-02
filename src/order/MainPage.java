package order;

import java.util.Scanner;

//import static order.Menu.*;

public class MainPage {
    //첫 메인페이지
    public static Scanner sc = new Scanner(System.in);
    static void showIndex() throws InterruptedException {
        Etc.lineDiv();
        System.out.println("Hello SHAKESHACK World!!!\n" +
                "아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.\n\n" +
                "[ SHAKESHACK MENU ]\n" +
                "1. "+String.format("%-15s",Menu.m1.getMenu())+"| "+Menu.m1.desc+"\n" +  //생성자에서 수정하면 자동적용.
                "2. "+String.format("%-15s",Menu.m2.getMenu())+"| "+Menu.m2.desc+"\n" +
                "3. "+String.format("%-15s",Menu.m3.getMenu())+"| "+Menu.m3.desc+"\n" +
                "4. "+String.format("%-15s",Menu.m4.getMenu())+"| "+Menu.m4.desc+"\n" +
                "\n[ ORDER MENU ]\n" +
                "5. "+String.format("%-15s",Menu.m5.getMenu())+"| "+Menu.m5.desc+"\n" +
                "6. "+String.format("%-15s",Menu.m6.getMenu())+"| "+Menu.m6.desc+"\n");
//        Scanner sc = new Scanner(System.in);
        switch (sc.nextInt()){
            case 1 :
                // 버거스 메뉴
                Product.showList(Product.burgersList, Menu.m1.getMenu());
                break;
            case 2 :
                // 커스타드 메뉴
                Product.showList(Product.frozenList, Menu.m2.getMenu());
                break;
            case 3 :
                // 음료 메뉴
                Product.showList(Product.drinksList, Menu.m3.getMenu());
                break;
            case 4 :
                // 맥주 메뉴
                Product.showList(Product.beerList, Menu.m4.getMenu());
                break;
            case 5 :
                // 장바구니 확인
                Etc.lineDiv();
                Order.showTotalOrder();
                break;
            case 6 :
                //취소. 장바구니 초기화.
                Order.cancleOrder();


                showIndex();
                break;
            case 0 :
                //정산. 총금액
                SellingSheet.showSheet();
                break;

            default:
                System.out.println("올바르지 않은 입력입니다.");
                showIndex();

        }

    }
}
