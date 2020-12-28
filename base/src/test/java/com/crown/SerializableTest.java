package com.crown;

import com.crown.io.serializable.entity.Person;

import java.io.*;

/**
 * @ClassName SerializableTest
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020-08-07
 * @Time 10:34
 * @Version 1.0
 */
public class SerializableTest {

    public static void main(String[] args) throws Exception {
        //序列化
        //serialize();

        //反序列化
        deSerialize();

        new Person();
    }

    private static void serialize() throws Exception {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("object")));
        Person person = new Person();
        person.setName("Crown");
        person.setAge(18);
        objectOutputStream.writeObject(person);
        objectOutputStream.close();
        System.out.println("序列化成功");
    }

    private static void deSerialize() throws Exception {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("object")));
        Person person = (Person) objectInputStream.readObject();
        System.out.println(person);

    }
}
