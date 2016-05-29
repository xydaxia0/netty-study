package com.craft.venus.serialization;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;

/**
 * Created by Xavier on 2016/5/30.
 */
public class PerformTestUserInfo {

    public static void main(String[] args) throws IOException {
        UserInfo info = new UserInfo();
        info.buildUserID(100).buildUserName("Welcome to netty");
        int loop = 1000000;
        ByteArrayOutputStream byteArrayOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(info);
            objectOutputStream.flush();
            objectOutputStream.close();
            byte[] b = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        }
        long endTime = System.currentTimeMillis();
        System.out.println(" the jdk serializable cost time is : " + (endTime - startTime) + " ms");
        System.out.println("--------------------------------------------------------------------------");
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        startTime = System.currentTimeMillis();
        for (int i= 0; i < loop; i++) {
            byte[] b = info.codeC(buffer);
        }
        endTime = System.currentTimeMillis();
        System.out.println("The byte arrsy serializable cost time is : " + (endTime - startTime) + " ms");
    }

}
