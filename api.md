>#服务器端和安卓端对接API设计


**本应用采用类似于json格式的数据进行交互**
<br>
**将数据String转化成字节流发送**
<br>
**到对方之后再转化为String**
<br>
**第一行代表方法MSG 后面数行代表数据**
<br>
**实际操作时没有括号**

>##公共

```

Success Response : {
    MSG  : "OK"
    Data : {
       （视情况而定）
    }
}
Error Response : {
    MSG  : "ERROR"
    Data : {
        errorCode : int
    }
}

```

>##登录验证相关

```

1001 注册
Requeset : {
    MSG : "SignUp"
    Data : {
        userName : String （限制10个字符以内）
        userPass : String （5-10个字符）
    }
}
Success Response : {
    MSG : "OK"
    Data : {
        ISI ： int （用户识别码）
    }
}
errorCode    error
    0        未知错误
    1        用户名已存在
    2        用户名格式非法(除字母数字下划线外的都视为非法，且为4到16位字符长度，以字母开头)
    3        密码过短
    
```

```

1002 登录
Requeset : {
    MSG : "Login"
    Data : {
        userName : String （限制10个字符以内）
        userPass : String （5-10个字符）
    }
}
Success Response : {
    MSG  : "OK"
    Data : {
        ISI ： int （用户识别码）
    }
}
errorCode    error
    0        未知错误
    1        密码不正确
    2        用户不存在
    
```

>##备忘录相关

```

2001 下载备忘录列表
Requeset : {
    MSG : "GET_toDoList"
    Data : {
        ISI ： int （用户识别码）
    }
}
Success Response : {
    MSG : "OK"
    Data : {
        toDolist  : [{
            title : String
            id    : int
        }]
    }
}
errorCode    error
    0        未知错误
    1        用户识别码不正确
    2        找不到内容
  
```

```

2002 下载备忘录文字内容
Requeset : {
    MSG : "GET_toDoListContent"
    Data : {
        ISI ： int （用户识别码）
        id  :  int （备忘录是第几条)
    }
}
Success Response : {
    MSG : "OK"
    Data : {
        title : String (备忘录标题)
        text  : String (备忘录描述)
        src   : String (图片文件名)
    }
}
errorCode    error
    0        未知错误
    1        用户识别码不正常
    2        找不到内容
  
```

```

2003 下载备忘录图片
Requeset : {
    MSG : "GET_toDoListPic"
    Data : {
        ISI ： int （用户识别码）
        id  :  int （备忘录是第几条)
    }
}
Success Response : {
    MSG : "OK"
    Data : {
        图片
    }
}
errorCode    error
    0        未知错误
    1        用户识别码不正确
    2        找不到内容
    3        图片传输失败
  
```

```

2004 上传备忘录
Requeset : {
    MSG : "POST_toDoListContent"
    Data : {
       ISI      ： int   （用户识别码）
       userName : String （用户名）
       title    : String （备忘录标题）
       text     : String （备忘录描述）
       src      : String （图片文件名）
       图片数据
    }
}
Success Response : {
    MSG : "OK"
    Data : {
        id  :  int （备忘录是第几条)
    }
}
errorCode    error
    0        未知错误
    1        用户识别码不正确
  
```

```

2005 上传备忘录图片
Requeset : {
    MSG : "POST_toDoListPic"
    Data : {
        ISI ： int     （用户识别码）
        id  :  int     （备忘录是第几条)
        src :  String  （图片文件名）
        图片
    }
}
Success Response : {
    MSG : "OK"
    Data : {
        
    }
}
errorCode    error
    0        未知错误
    1        用户识别码不正确
    2        图片传输失败
  
```

```

2006 删除备忘录
Requeset : {
    MSG : "DELETE_toDoList"
    Data : {
        ISI ： int     （用户识别码）
        id  :  int     （备忘录是第几条)
    }
}
Success Response : {
    MSG : "OK"
    Data : {
        
    }
}
errorCode    error
    0        未知错误
    1        找不到该备忘录
  
```

```

2007 更新备忘录
Requeset : {
    MSG : "PUT_toDoList"
    Data : {
        ISI   ： int     （用户识别码）
        id    :  int     （备忘录是第几条)
        title : String  (备忘录标题)
        text  : String  (备忘录描述)
        src   : String  (图片文件名)
    }
}
Success Response : {
    MSG : "OK"
    Data : {
        
    }
}
errorCode    error
    0        未知错误
    1        找不到该备忘录
  
```

