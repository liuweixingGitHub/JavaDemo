public interface TestLambdaService {

    /**
     * 你看你这里面有三个方法，对啊，一般会书写接口的，或者基础比较好的，都知道，
     * 接口里面是可以书写默认方法和静态方法的，这种方法是没有限制的，但是抽象方法必须只有一个（普及下知识点哈：抽象方法是没有方法体的，只是虚函数）
     */



    String test(String name);
    default void test1(){

        System.out.println("aaaa123 = " + 123);
    }
    static void test2(){System.err.println("#test2 perform");}



}
