import java.lang.ref.SoftReference;
import java.util.*;

public class main {



    public static void main(String[] args) {


//        TestLambdaService testLambdaService = (s)-> System.out.println(">>>"+s);
//
//
////        testLambdaService.test("xiaoming");
//        testLambdaService.test1();;

//    String name="jim";
//
//
//        String finalName = name;
//        Runnable runnable =  new Runnable() {
//
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//
//                System.out.println("name = " + finalName);
//            }
//        };
//
//
//        Thread thread = new Thread(runnable);
//
//        name = "tom";
//        thread.start();;
//        System.out.println("name = " + name);


//        List list = Arrays.asList(0,1,2,3);
////        list.add(4);
//
//        System.out.println("list = " + list);
//        list.add(4);


//        List obj = new ArrayList<Integer>() {{
//            add(1);
//            add(3);
//
//        }};
//
//
//
//
//        List<Integer> items = Collections.unmodifiableList(Arrays.asList(0,1,2,3));
//        items.add(2);


//        Map aMap = new HashMap();
//        aMap.put(1, "one");
//        aMap.put(2, "two");
//        Map map = Collections.unmodifiableMap(aMap);
//
//        System.out.println("aMap = " + aMap);
//        System.out.println("map = " + map);
//
//        aMap.put(3,"there");
//
//        System.out.println("aMap = " + aMap);
//        System.out.println("map = " + map);
//        map.put(3,"there2");



//        List<String> list = List.of("a", "b", "a", "c", "d");
//        System.out.println(list);//[a, b, a, c, d]
//
//
//        list.add("f");


//        List list1 = Arrays.asList(0,1,2,3);
//        System.out.println("list1 = " + list1);
//        list1.add(4);


        List list1 = Arrays.asList(0,1,2,3);
        System.out.println("list1 = " + list1);
        list1.add(4);


        //        LambdaObject.LambdaModel lambdaModel = s ->{ System.out.println("s = " + s); return "xiaoming"+s ;};
//        LambdaObject lambdaObject = new LambdaObject(lambdaModel);



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
