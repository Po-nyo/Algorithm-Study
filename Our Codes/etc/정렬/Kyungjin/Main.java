package simple_sort.solution;

import java.util.Scanner;
import java.util.Arrays;

class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Person[] people = new Person[n];
        scan.nextLine();

        for(int i=0; i<n; i++) {
            people[i] = new Person(scan.next(), scan.nextInt());
            scan.nextLine();
        }

        Arrays.sort(people);

        for(Person p : people)
            System.out.println(p.name);
    }

    static class Person implements Comparable<Person> {
        private String name;
        private int age;

        private Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public int compareTo(Person other) {
            return -Integer.compare(this.age, other.age);
        }
    }
}
