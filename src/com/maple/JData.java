package com.maple;

import java.net.*;
import java.util.*;
import java.util.Map.*;

public abstract class JData {
    Map<String, String> mapString = null;
    Map<String, Integer> mapInt = null;
    String msg = null;

    JData(Socket soc, String Request) {
    }

    public void setMSG(String MSG) {
        this.msg = MSG;
    }

    @Override
    public String toString() {
        Iterator<Entry<String, Integer>> intPairs = this.mapInt.entrySet().iterator();
        Iterator<Entry<String, String>> StringPairs = this.mapString.entrySet().iterator();
        StringBuffer response = new StringBuffer();
        for (int i = 0; i < this.mapInt.size(); i++) {
            Entry<String, Integer> entry = intPairs.next();
            response.append(entry.getKey());
            response.append(":");
            response.append(entry.getValue());
            response.append("\n");
        }
        for (int i = 0; i < this.mapString.size(); i++) {
            Entry<String, String> entry = StringPairs.next();
            response.append(entry.getKey());
            response.append(":");
            response.append(entry.getValue());
            response.append("\n");
        }
        return response.toString();
    }

}
