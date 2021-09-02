/**
 * @ BJ 5635 생일
 * @ prob : https://www.acmicpc.net/problem/5635
 */

import java.time.LocalDate;
import java.util.Scanner;

public class BJ_5635 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Student[] studentArr = new Student[n];

        for(int i = 0; i < n; i++) {
            String name = sc.next();
            String[] arr = sc.nextLine().trim().split(" ");
            String birth = String.format("%s-%02d-%02d", arr[2], Integer.valueOf(arr[1]), Integer.valueOf(arr[0]));
            studentArr[i] = new Student(name, LocalDate.parse(birth));
        }

        Student youngestStu = new Student("", LocalDate.MIN);
        Student oldestStu = new Student("", LocalDate.MAX);
        
        for(int i = 0; i < n; i++) {
            if(studentArr[i].getBirth().compareTo(youngestStu.getBirth()) > 0) {
                youngestStu.setName(studentArr[i].getName());
                youngestStu.setBirth(studentArr[i].getBirth());
            }
            if(studentArr[i].getBirth().compareTo(oldestStu.getBirth()) < 0) {
                oldestStu.setName(studentArr[i].getName());
                oldestStu.setBirth(studentArr[i].getBirth());
            }
        }

        System.out.println(youngestStu.getName());
        System.out.println(oldestStu.getName());
        
        sc.close();
    }
}

class Student {
    private String name = "";
    private LocalDate birth;

    Student(String name, LocalDate birth) {
        this.name = name;
        this.birth = birth;
    }

    String getName() {
        return this.name;
    }

    LocalDate getBirth() {
        return this.birth;
    }

    void setName(String name) {
        this.name = name;
    }

    void setBirth(LocalDate birth) {
        this.birth = birth;
    }
}