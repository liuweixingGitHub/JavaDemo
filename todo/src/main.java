import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class main {



    public static void main(String[] args) {


//        TestLambdaService testLambdaService = (s)-> System.out.println(">>>"+s);
//
//
////        testLambdaService.test("xiaoming");
//        testLambdaService.test1();;


//        new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        });




        LambdaObject.LambdaModel lambdaService = s ->{ System.out.println("s = " + s); return "xiaoming"+s ;};
        LambdaObject lambdaObject = new LambdaObject(lambdaService);



//        Student stuA = new Student(1, "A", "M", 184);
//        Student stuB = new Student(2, "B", "G", 163);
//        Student stuC = new Student(3, "C", "M", 175);
//        Student stuD = new Student(4, "D", "G", 158);
//        Student stuE = new Student(5, "E", "M", 170);
//        List<Student> list = new ArrayList<>();
//        list.add(stuA);
//        list.add(stuB);
//        list.add(stuC);
//        list.add(stuD);
//        list.add(stuE);
//
//        list.forEach(student -> System.out.println("student = " + student.getName()));



//        list.stream()
//                .filter(student -> student.getSex().equals("G"))
//                .forEach(student -> System.out.println(">>>"+student.getName()));

//        list.stream().map(student -> System.out.println("student = " + student));

//        List<Student> idcards= list.stream().filter(student -> student.getName().equals("A")).collect(Collectors.toList());
//        System.out.println(idcards);
//        list.stream().forEach(student -> System.out.println("student = " + student.getName()));

//        list.forEach(student -> System.out.println("student = " + student.getName()));
//        list.stream().forEach(student -> System.out.println("student = " + student.getName()));
//        List<Student> collect = list.stream().map(student -> {
//            System.out.println("student = " + student.getName();
//            return student;
//        });
//        System.out.println(collect); //[A, B, C, D]



    }
}
