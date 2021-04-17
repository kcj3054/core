package hello.core.singleton;

//springBean 무조건 무상태로 설계해야한다
public class StatefulService {
   // private  int price; // 상태 유지하는 필드

    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
     //   this.price = price;
        return price;
    }

//    public int getPrice(){
//        return price;
//    }

}
