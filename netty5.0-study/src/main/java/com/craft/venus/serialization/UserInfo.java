package com.craft.venus.serialization;

import java.io.Serializable;
import java.nio.ByteBuffer;

/**
 * Created by Xavier on 2016/5/29.
 */
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private  String userName;

    private int userID;

    public UserInfo buildUserID(int userID) {
        this.userID = userID;
        return this;
    }

    public UserInfo buildUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public byte[] codeC() {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        byte[] value = this.userName.getBytes();
        buffer.putInt(value.length);
        buffer.put(value);
        buffer.putInt(this.userID);
        buffer.flip();
        value = null;
        byte[] result = new byte[buffer.remaining()];
        buffer.get(result);
        return result;
    }

    public byte[] codeC(ByteBuffer buffer) {
        buffer.clear();
        byte[] value = this.userName.getBytes();
        buffer.putInt(value.length);
        buffer.put(value);
        buffer.putInt(this.userID);
        buffer.flip();
        value = null;
        byte[] result = new byte[buffer.remaining()];
        buffer.get(result);
        return result;
    }
}
