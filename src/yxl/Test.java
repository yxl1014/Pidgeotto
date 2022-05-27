package yxl;

public class Test {
    public static void main(String[] args) {
        LruList list = new LruList(5);
        System.out.println("-----");
        System.out.println(list.addData(1, "aaa"));
        System.out.println(list.addData(2, "bbb"));
        System.out.println(list.addData(3, "ccc"));
        System.out.println(list.addData(4, "ddd"));
        System.out.println(list.addData(5, "eee"));
        System.out.println("-----");
        list.display();
        System.out.println("-----");
        System.out.println(list.addData(5, "fff"));
        System.out.println(list.addData(7, "ggg"));
        System.out.println("-----");
        list.display();
        System.out.println("-----");
        System.out.println(list.addData(3, "hhh"));
        System.out.println(list.addData(4, "iii"));
        System.out.println(list.addData(5, "jjj"));
        System.out.println("-----");
        list.display();
        System.out.println("-----\n" + list.getData(2));
        System.out.println("-----\n" + list.getData(3));
        System.out.println("-----\n" + list.getData(4));
        System.out.println("-----\n" + list.getData(5));
        System.out.println("-----\n" + list.getData(7));
        System.out.println("-----");
        list.display();
    }
}
