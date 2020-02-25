

public class LambdaObject {

    public interface LambdaModel {
        String test(String name);
    }


    LambdaObject(LambdaModel model){

     String string =  model.test("123");

        System.out.println("string = " + string);

//        service.test1();;
//        new Thread(()->{
//
//        }).start();

    };



}
