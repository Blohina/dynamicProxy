package com.company;
import java.lang.reflect.Proxy;
import java.lang.reflect.*;

class Man implements Person{
    private String myname;
    private int age;
    private String myCity;

    public Man(String name, int age, String city) {
        this.myname = name;
        this.age = age;
        this.myCity = city;
    }

    @Override
    public void getYourName() {
        System.out.println("My name is " + myname);
        //return "My name is " + myname;
    }
    @Override
    public void getAge() {
        System.out.println("I am " + age);
    }
    @Override
    public void getCity() {
        System.out.println("I am from " + myCity);
    }

}
public class Main {

    public static void main(String[] args) {
    Man women = new Man("bob", 20,"Moscow");
    women.getAge();

    // Хочу подменить методы
        //1. Создадим класс реализующий InvokationHandler interface (MyInvokeitionHandler.java)
        //2. В этом классе создадим ссылку на интерфейс, методы которого перехватываем
        //3. Переопределим метод invoke() интерфейса InvokationHandler()

        // Создадим объект прокси и настроим его на women
      Person proxyWomen = (Person) Proxy.newProxyInstance(women.getClass().getClassLoader(),
                                                          women.getClass().getInterfaces(),
                                                          new MyInvoketionHandler(women));
      proxyWomen.getYourName();
      proxyWomen.getCity();

    }
}
