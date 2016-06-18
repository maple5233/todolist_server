package com.maple;

import java.net.Socket;

public class ToDoList extends JData {

    public ToDoList(Socket soc, String Request) {
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

}
