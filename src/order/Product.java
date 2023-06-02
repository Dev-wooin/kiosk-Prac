package order;

import java.util.ArrayList;

public class Product extends Menu {
    //멤버 선언
    double price;

    //생성자
    Product(String name, double price, String desc){
        this.name = name;
        this.price = price;
        this.desc = desc;
    }

    //생성되자마자 해당 리스트에 할당하고 싶은데. 안됨.
    Product(ArrayList<Product> list, String name, double price, String desc){
        this.name = name;
        this.price = price;
        this.desc = desc;
        list.add(this); //이게 작동이 안되는듯.
    }

    //getter 메소드
    String getName(){
        return name;
    }
    double getPrice(){
        return price;
    }
    @Override
    String getDesc(){
        return desc;
    }


    //각 메뉴별 상품 담아줄 arraylList생성
    static ArrayList<Product> burgersList = new ArrayList<>();
    static ArrayList<Product> frozenList = new ArrayList<>();
    static ArrayList<Product> drinksList = new ArrayList<>();
    static ArrayList<Product> beerList = new ArrayList<>();

    //각 상품 생성 및 리스트에 추가.
    static void loadingList() {
        System.out.println("Product생성완료");
        //burgers
        burgersList.add(new Product("ShackBurger",6.9,"토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgersList.add(new Product("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgersList.add(new Product("ShroomBurger", 9.4, "몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거"));
        burgersList.add(new Product("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgersList.add(new Product("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));
        //Frozen custard
        frozenList.add(new Product("Shakes", 5.9, "바닐라, 초콜렛, 솔티드카라멜, 블랙&화이트, 스트로베리, 피넛버터, 커피"));
        frozenList.add(new Product("Shake of the week", 6.5, "특별한 커스터드 플레이버"));
        frozenList.add(new Product("Red Bean Shake", 6.5, "신선한 커스터드와 함께 우유와 레드빈이 블렌딩된 시즈널 쉐이크"));
        frozenList.add(new Product("Floats", 5.9, "루트 비어, 퍼플 카우, 크림시클"));
        //Drinks
        drinksList.add(new Product("Shack-made Lemonade", 3.9, "매장에서 직접 만드는 상큼한 레몬에이드"));
        drinksList.add(new Product("Fresh Brewed Iced Tea", 3.4,"직접 유기농 홍차를 우려낸 아이스티"));
        drinksList.add(new Product("Fifty/Fifty",3.5,"레몬에이드와 아이스티의 만남"));
        //Beer
        beerList.add(new Product("ShackMeister Ale", 9.8, "뉴욕 브루클린 브루어리에서 특별히 양조한 에일 맥주"));
        beerList.add(new Product("Magpie Brewing Co.", 6.8,"맥파이 브루잉에서 특별히 제조한 맥주"));
    }

    //해당 메뉴의 상품을 보여주는 메소드. 상품 객체들을 담은 arrayList를 인자로 받음
    static void showList(ArrayList<Product> arrayList, String menu) throws InterruptedException {
        Etc.lineDiv(); //구분선
        System.out.println(
                        "\"SHAKESHACK BURGER 에 오신걸 환영합니다.\"\n" +
                        "아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.\n\n" +
                        "[ "+menu+" MENU ]");
        ArrayList<Product> tempList = new ArrayList<>(); // 카테고리 해당 리스트 받아줄 arrayList.
        //
        for(int idx=0; idx<arrayList.size(); idx++){
            Product product = arrayList.get(idx);
            tempList.add(arrayList.get(idx));
            System.out.println(idx+1+". "+product.getName()+"  | W "+product.getPrice()+" | "+product.getDesc());
        }
//        for(Product product : arrayList){
//            int idx =1;
//            System.out.println(idx+". "+product.getName()+"  | W "+product.getPrice()+" | "+product.getDesc());
//            idx
//        }
        System.out.println("\n원하는 상품의 번호를 입력해주세요.");
        int ans = MainPage.sc.nextInt();
        if(ans<1 || ans > tempList.size()) {
            System.out.println("올바르지 않은 입력입니다.");
            showList(arrayList, menu);

        } else {
            Order.checkOrder(tempList.get(ans - 1));
        }

    }


//    static void showBurgerList(ArrayList<Product> list){
//        for(Product product : list){
//            product.getName();
//        }
//    }






}