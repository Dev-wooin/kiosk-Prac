package order;

public class Menu {
    String name;
    String desc;

    public Menu() {
    }
    String getMenu(){
        return name;
    }
    String getDesc(){
        return desc;
    }

    void printStr(){
        System.out.println();
    }

    public Menu(String menu, String desc){
        this.name = menu;
        this.desc = desc;
    }


//    ArrayList<Menu> menuArrayList = new ArrayList<>();

    static Menu m1 = new Menu("Burgers","앵거스 비프 통살을 다져만든 버거");
    static Menu m2 = new Menu("Frozen Custard","매장에서 신선하게 만드는 아이스크림");
    static Menu m3 = new Menu("Drinks","매장에서 직접 만드는 음료");
    static Menu m4 = new Menu("Beer","뉴욕 브루클린 브루어리에서 양조한 맥주");
    static Menu m5 = new Menu("Order","장바구니를 확인 후 주문합니다.");
    static Menu m6 = new Menu("Cancel","진행중인 주문을 취소합니다.");

}
