package test;

import org.aspectj.util.Reflection;

import java.lang.reflect.Field;

public class LearnReflection {

    public static void main(String[] args) {
        Cat myCat = new Cat("Tom", 5);
        Class catClass = myCat.getClass();
        Field[] fields = catClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }
    }


}

class Cat {
    private String name;
    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void heyThisIsStatic() {
        System.out.println("This is static");
    }

    private static void heyThisIsPrivateStatic() {
        System.out.println("This is private static");
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void meow() {
        System.out.println("Meow");
    }

    private void heyThisIsPrivate() {
        System.out.println("This is private");
    }

    //what is reflection:
    /**
     Reflection is the ability of a computer program to examine, introspect, and modify its own structure and behavior at runtime.
     Reflection is used to dynamically analyze and modify classes, methods, attributes at runtime.
     Reflection is a feature in the Java programming language. It allows an executing Java program to examine or "introspect" upon itself, and manipulate internal properties of the program.
     For example, it's possible for a Java class to obtain the names of all its members and display them.
     Reflection is a feature in the Java programming language. It allows an executing Java program to examine or "introspect" upon itself, and manipulate internal properties of the program. For example, it's possible for a Java class to obtain the names of all its members and display them.
     */


}
