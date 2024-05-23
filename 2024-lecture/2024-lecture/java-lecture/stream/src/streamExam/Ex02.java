import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.function.*;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private int age;
    private String dept;
    private int salary;

    public Employee() {}

    public Employee(String name,  int age, String dept, int salary) {
        this.name = name;
        this.dept = dept;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }


    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        String info = name+", " + age +", "  + dept +", "  + salary;
        return info;
    }
}

public class Ex02 {
    public static void main(String[] args) {
        List<String> fruitList =
                Arrays.asList("apple","banana","apple","mango","strawberry","banana", "mango");
        //Supplier, Consumer, Predicate, Function
        fruitList.stream()
                .filter(s -> s.startsWith("a"))
                .distinct()
                .forEach(s -> System.out.println(s));

        List<Employee> empList = Arrays.asList(
                new Employee("홍길동", 30, "총무부", 2000000),
                new Employee("일런머스크", 26, "개발부", 2400000),
                new Employee("이순신", 32, "회계부", 3000000),
                new Employee("유재석", 40, "인사부", 4000000),
                new Employee("손흥민", 26, "개발부", 2400000),
                new Employee("정준하", 28, "회계부", 2700000),
                new Employee("스티브잡스", 26, "개발부", 2400000),
                new Employee("홍판서", 60, "총무부", 7000000),
                new Employee("제임스고슬링", 26, "개발부", 2400000)
        );
        // 제일 좋은 방법은 sql
        double avg = empList.stream()
                .mapToInt(emp -> emp.getSalary())
                .average()
                .getAsDouble();

//        if(optionalDouble.isPresent()) {
//            optionalDouble.getAsDouble();
//        } else {
//            System.out.println("연산이 수행되지 않았습니다.");
//        }
        //.getAsDouble();

        System.out.println(avg);

        List<Employee> empFilterList = empList.stream()
                .filter(employee -> employee.getDept().equals("회계부"))
                .collect(Collectors.toList());
        empFilterList.forEach(employee -> System.out.println(employee.getName()));

        //이런것들 웬만하면 sql에 다 있다 sql에서 연산해서 결과를 돌려받는게 낫다.
        Map<String,List<Employee>> groupList = empList.stream()
                .collect(Collectors.groupingBy(Employee::getDept));
        System.out.println("=============");
        groupList.forEach((s, employees) -> {
            System.out.print(s+"==");
            employees.forEach(employee -> {
                System.out.print(employee.getName()+",");
            });
            System.out.println();
        });
    }
}
