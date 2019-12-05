

public class LambdaObject {

    public interface LambdaModel {
        String test(String name);
    }


    LambdaObject(LambdaModel service){

     String string =  service.test("123");

        System.out.println("string = " + string);

//        service.test1();;
//        new Thread(()->{
//
//        }).start();

    };



}
