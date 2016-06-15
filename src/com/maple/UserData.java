package com.maple;

import java.io.*;
import java.net.*;
import java.util.regex.*;

public class UserData extends JData {

    public UserData(Socket soc, String Request) {
        // TODO 自动生成的构造函数存根
        super(soc, Request);
        String[] datas = Request.split("\n");
        for (String str : datas) {
            String key = str.split(":")[0];
            String value = str.split(":")[1];
            if (key.equals("MSG")) {
                this.msg = value;
            } else if (key.equals("ISI")) {
                this.mapInt.put(key, Integer.parseInt(value));
            } else {
                this.mapString.put(key, value);
            }
        }
    }

    public int login() {
        // TODO 自动生成的方法存根
        String un = this.mapString.get("userName");
        String up = this.mapString.get("userPass");
        int result = 0;// 0 找不到用户
        try {
            String userData;
            BufferedReader bfr = new BufferedReader(new FileReader(ConstString.SRC_TO_ROOT + "db/user.txt"));
            while ((userData = bfr.readLine()) != null) {
                String userName = userData.split(" ----- ")[0];
                String userPass = userData.split(" ----- ")[1];
                if (un.equals(userName)) {
                    result++;// 1 密码不对
                    if (up.equals(userPass)) {
                        result++;// 2 验证成功
                    }
                }
            }
            bfr.close();
        } catch (Exception e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        return result;
    }

    @SuppressWarnings("resource")
    public int SignUp() {
        // TODO 自动生成的方法存根
        String un = this.mapString.get("userName");
        String up = this.mapString.get("userPass");
        int result = 0;// 0 成功
        final String USERNAME_PATTERN = "^[a-zA-Z]{1}[a-zA-Z0-9_]{3,15}$";
        Pattern pattern = Pattern.compile(USERNAME_PATTERN);
        Matcher matcher = pattern.matcher(un);
        if (!matcher.matches()) {
            result += 2;// 用户名格式不合法
            return result;
        }
        try {
            String userData;
            BufferedReader bfr = new BufferedReader(new FileReader(ConstString.SRC_TO_ROOT + "db/user.txt"));
            while ((userData = bfr.readLine()) != null) {
                String userName = userData.split(" ----- ")[0];
                if (un.equals(userName)) {
                    result++;// 1 用户已经存在
                    return result;
                }
            }
            BufferedWriter bfw = new BufferedWriter(new FileWriter(ConstString.SRC_TO_ROOT + "db/user.txt", true));
            int ISI = (int) (up.hashCode() + System.currentTimeMillis() * 100);
            this.mapInt.put("ISI", ISI);
            result = ISI;
            bfw.write(un + " ----- " + up + " ----- " + ISI + "\n");
        } catch (Exception e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        return result;
    }
}
