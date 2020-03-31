package com.company;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//1. Создадим класс реализующий InvokationHandler interface (MyInvokeitionHandler.java)
//2. В этом классе создадим ссылку на интерфейс, методы которого перехватываем
//3. Переопределим метод invoke() интерфейса InvokationHandler()

public class MyInvoketionHandler implements InvocationHandler {
    Person person;

    MyInvoketionHandler(Person person) {
        this.person = person;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        if(method.getName().equals("getCity")) {
            System.out.println("I love my city! ");
        }
        if(method.getName().equals("getYourName")) {
            System.out.println("I have a nice name!");
        }
        return method.invoke(person,objects);
    }
}
