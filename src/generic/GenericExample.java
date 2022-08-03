package generic;

import java.util.ArrayList;

class Product{}
class Tv extends Product {}
class Audio extends Product {}

public class GenericExample {
    public static void main(String[] args) {
        // 컴파일 시에 타입을 체크해주는 기능 (Generic)
        // 형변환을 생략할 수 있어 코드가 간결해진다.
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(4);

        System.out.println(list);

        ArrayList<Product> productList = new ArrayList<Product>();
        ArrayList<Tv>  tvList = new ArrayList<Tv>();
        ArrayList<Audio> audioList = new ArrayList<Audio>();

        // 모두 가능
        productList.add(new Product());
        productList.add(new Tv());
        productList.add(new Audio());

        // Tv만 가능
//        tvList.add(new Product());
        tvList.add(new Tv());
//        tvList.add(new Audio());

        // Audio만 가능
//        audioList.add(new Product());
//        audioList.add(new Tv());
        audioList.add(new Audio());

        printAll(productList);
        printAll(tvList);
        printAll(audioList);
    }

    public static <E> void printAll(ArrayList<E> list) {
        for (E p : list) {
            System.out.println(p);
        }
    }
}
