package com.craft.venus.serialization;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by Xavier on 2016/5/29.
 */
public class TestUserInfo {

    public static void main(String[] args) throws IOException {
        UserInfo userInfo = new UserInfo();
        String string = "Welcome to netty!";
        for (int i = 0; i < 10; i++) {
            string = string + "Welcome to netty!";
        }
        userInfo.buildUserID(100).buildUserName(string);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(userInfo);
        objectOutputStream.flush();
        objectOutputStream.close();
        byte[] b = byteArrayOutputStream.toByteArray();
        System.out.println("the jdk serializable length is : " + b.length);
        byteArrayOutputStream.close();
        System.out.println("-----------------------------------------------------");
        System.out.println("the byte array serializable length is : " + userInfo.codeC().length);
    }
}
