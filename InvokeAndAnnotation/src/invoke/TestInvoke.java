package invoke;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @description: invoke.TestInvoke
 * 获取字节码对象
 * 获取构造方法
 * 根据构造方法创建对象
 * 对象调方法
 * @author: jie
 * @date: 2023/8/7
 **/
public class TestInvoke {



    @Test
    public void testInvoke(){
        ArrayList<Object> list = new ArrayList<>();
        Class<? extends ArrayList> listClass = list.getClass();
        int modifiers = listClass.getModifiers();

        Class<?>[] declaredClasses = listClass.getDeclaredClasses();
        System.out.println("declaredClasses = " + Arrays.toString(Arrays.stream(declaredClasses).toArray()));

        Class<?>[] exceptionTypes = new Class[0];
        try {
            exceptionTypes = listClass.getConstructor().getExceptionTypes();
            int parameterCount = listClass.getConstructor().getParameterCount();
            System.out.println("parameterCount = " + parameterCount);

            for (Parameter parameter : listClass.getConstructor().getParameters()) {
                System.out.println("parameter = " + parameter.getName());
            }

        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        System.out.println("exceptionTypes = " + Arrays.toString(exceptionTypes));

        System.out.println("modifiers = " + modifiers);
        System.out.println("listClass = " + listClass);
    }

    @Test
    public void testConstructor(){
        Class<ArrayList> clazz = ArrayList.class;

        Constructor<ArrayList> constructor = null;
        try {
            constructor = clazz.getConstructor();

            String name = constructor.getName();
            System.out.println("name = " + name);

            for (Parameter parameter : constructor.getParameters()) {
                System.out.println("parameter = " + parameter.getName());
            }

            ArrayList arrayList = null;
            try {
                //实例化对象
                arrayList = constructor.newInstance();
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            arrayList.add("jiejie");
            //arrayList.remove("jiejie");
            System.out.println("arrayList = " + arrayList);

        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        System.out.println("constructor = " + constructor);
    }

    @Test
    public void testFilId(){

        try {
            Field declaredField = ArrayList.class.getDeclaredField("size");

            Class<?> forName = Class.forName("java.util.ArrayList");

            Object newInstance = forName.getConstructor(int.class).newInstance(100);

            String name = declaredField.getName();
            System.out.println("declaredField = " + declaredField);
            System.out.println("name = " + name);
            declaredField.setAccessible(true);
            declaredField.setInt(newInstance,123);
            Object o = declaredField.get(newInstance);


            Object get = forName.getDeclaredMethod("get", int.class).invoke(newInstance, 20);

            System.out.println("get = " + get);


            System.out.println("o = " + o);

        } catch (NoSuchFieldException | IllegalAccessException | ClassNotFoundException | InstantiationException |
                 InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testMethod(){
        try {
            Class listClas = Class.forName("java.util.ArrayList");
            Constructor<?>[] listCons = listClas.getConstructors();
            Constructor newConstructor= null;
            for (Constructor constructor: listCons) {
                if(constructor.getParameterCount() ==0 ){
                    newConstructor = constructor;
                }
            }
            Object arrayList = newConstructor.newInstance();

            //获取方法
            //通过方法名+参数类型去获取具体某个Method对象
            //方法签名= 方法名+类型类型
            //listClas.getMethod("方法名","参数类型");

            //获取所有的方法
            // listClas.getMethods();

            //返回自己和父类的所有的public方法
            //返回包含一个数组 方法对象反射由此表示的类或接口的所有公共方法 类对象，包括那些由类或接口和那些从超类和超接口继承的声明。
            Method[]  methods = listClas.getMethods();
            System.out.println(methods.length);

            //获取所有的锁有的public和自己的私有的方法
            //通过此表示 类对象，包括公共，保护，默认（包）访问和私有方法，但不包括继承的方法。

            //你这个虽然能获取私有的，但是不能获取你父类的私有的
            Method[] declaredMethods =  listClas.getDeclaredMethods();
            System.out.println(declaredMethods.length);

            Method m0 = declaredMethods[0];
            //怎么去调用一个方法? 通过Method对象去调用invoke方法

            //第一个参数是Object对象，因为你的普通方法的调用是不是通过 对象.方法(),但是，如果是静态方法，第一个参数传null.

            //调用第0个方法(add(int,Object))
            m0.setAccessible(true);
            m0.invoke(arrayList,0,"123");

            Method m4 = declaredMethods[4];
            //调用第4的方法( get(i ))
            Object o = m4.invoke(arrayList,0);
            System.out.println(o);

           /* //调用fastRemove方法删除指定索引的值
            Method m43 = declaredMethods[43];
            m43.setAccessible(true);
            m43.invoke(arrayList,0);*/

            //在调用 get方法获取第0个值
            m4.setAccessible(true);
            Object o1 = m4.invoke(arrayList,0);
            System.out.println(o1);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }
}
