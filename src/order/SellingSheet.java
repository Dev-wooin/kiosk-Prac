package order;

import java.util.ArrayList;

public class SellingSheet {

    static ArrayList<Product> sellingList = new ArrayList<>();


    static void addOrder(ArrayList<Product> list){
        sellingList.addAll(list);
    }

    static String getTotalIncome(){
        double totalIncome=0;
        for(Product product : sellingList) {
            totalIncome += product.getPrice();
        }
        return String.format("%.1f",totalIncome);
    }

    static void printTotalSellingList() throws InterruptedException {
        System.out.println("[ 총 판매상품 목록 현황 ]\n" +
                "현재까지 총 판매된 상품 목록은 아래와 같습니다.");
        for(Product product : sellingList) {
            System.out.println("- "+product.getName()+" | W "+product.getPrice());
        }
        System.out.println("현재까지 총 판매된 금액은 [ W "+getTotalIncome()+" ] 입니다.\n" +
                "아무키나 눌러 돌아가기.");
        int ans = MainPage.sc.nextInt();
//        System.out.println("실행");
        MainPage.showIndex();
    }



    static void showSheet() throws InterruptedException {
        System.out.println("" +
                "[ 총 판매금액 현황 ]\n" +
                "현재까지 총 판매된 금액은 [ W " + getTotalIncome()+ " ] 입니다.\n" +
                "\n" +
                "1. 돌아가기  2. 판매목록 확인  3. 초기화");
        int ans=MainPage.sc.nextInt();
        switch (ans) {
            case 1 -> MainPage.showIndex();
            case 2 -> printTotalSellingList();
            case 3 -> sellingList.clear();
            default -> {
                MainPage.showIndex();
            }
        }

    }
}
