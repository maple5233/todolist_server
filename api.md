>#�������˺Ͱ�׿�˶Խ�API���


**��Ӧ�ò���������json��ʽ�����ݽ��н���**
<br>
**������Stringת�����ֽ�������**
<br>
**���Է�֮����ת��ΪString**
<br>
**��һ�д�����MSG �������д�������**
<br>
**ʵ�ʲ���ʱû������**

>##����

```

Success Response : {
    MSG  : "OK"
    Data : {
       �������������
    }
}
Error Response : {
    MSG  : "ERROR"
    Data : {
        errorCode : int
    }
}

```

>##��¼��֤���

```

1001 ע��
Requeset : {
    MSG : "SignUp"
    Data : {
        userName : String ������10���ַ����ڣ�
        userPass : String ��5-10���ַ���
    }
}
Success Response : {
    MSG : "OK"
    Data : {
        ISI �� int ���û�ʶ���룩
    }
}
errorCode    error
    0        δ֪����
    1        �û����Ѵ���
    2        �û�����ʽ�Ƿ�(����ĸ�����»�����Ķ���Ϊ�Ƿ�����Ϊ4��16λ�ַ����ȣ�����ĸ��ͷ)
    3        �������
    
```

```

1002 ��¼
Requeset : {
    MSG : "Login"
    Data : {
        userName : String ������10���ַ����ڣ�
        userPass : String ��5-10���ַ���
    }
}
Success Response : {
    MSG  : "OK"
    Data : {
        ISI �� int ���û�ʶ���룩
    }
}
errorCode    error
    0        δ֪����
    1        ���벻��ȷ
    2        �û�������
    
```

>##����¼���

```

2001 ���ر���¼�б�
Requeset : {
    MSG : "GET_toDoList"
    Data : {
        ISI �� int ���û�ʶ���룩
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
    0        δ֪����
    1        �û�ʶ���벻��ȷ
    2        �Ҳ�������
  
```

```

2002 ���ر���¼��������
Requeset : {
    MSG : "GET_toDoListContent"
    Data : {
        ISI �� int ���û�ʶ���룩
        id  :  int ������¼�ǵڼ���)
    }
}
Success Response : {
    MSG : "OK"
    Data : {
        title : String (����¼����)
        text  : String (����¼����)
        src   : String (ͼƬ�ļ���)
    }
}
errorCode    error
    0        δ֪����
    1        �û�ʶ���벻����
    2        �Ҳ�������
  
```

```

2003 ���ر���¼ͼƬ
Requeset : {
    MSG : "GET_toDoListPic"
    Data : {
        ISI �� int ���û�ʶ���룩
        id  :  int ������¼�ǵڼ���)
    }
}
Success Response : {
    MSG : "OK"
    Data : {
        ͼƬ
    }
}
errorCode    error
    0        δ֪����
    1        �û�ʶ���벻��ȷ
    2        �Ҳ�������
    3        ͼƬ����ʧ��
  
```

```

2004 �ϴ�����¼
Requeset : {
    MSG : "POST_toDoListContent"
    Data : {
       ISI      �� int   ���û�ʶ���룩
       userName : String ���û�����
       title    : String ������¼���⣩
       text     : String ������¼������
       src      : String ��ͼƬ�ļ�����
       ͼƬ����
    }
}
Success Response : {
    MSG : "OK"
    Data : {
        id  :  int ������¼�ǵڼ���)
    }
}
errorCode    error
    0        δ֪����
    1        �û�ʶ���벻��ȷ
  
```

```

2005 �ϴ�����¼ͼƬ
Requeset : {
    MSG : "POST_toDoListPic"
    Data : {
        ISI �� int     ���û�ʶ���룩
        id  :  int     ������¼�ǵڼ���)
        src :  String  ��ͼƬ�ļ�����
        ͼƬ
    }
}
Success Response : {
    MSG : "OK"
    Data : {
        
    }
}
errorCode    error
    0        δ֪����
    1        �û�ʶ���벻��ȷ
    2        ͼƬ����ʧ��
  
```

```

2006 ɾ������¼
Requeset : {
    MSG : "DELETE_toDoList"
    Data : {
        ISI �� int     ���û�ʶ���룩
        id  :  int     ������¼�ǵڼ���)
    }
}
Success Response : {
    MSG : "OK"
    Data : {
        
    }
}
errorCode    error
    0        δ֪����
    1        �Ҳ����ñ���¼
  
```

```

2007 ���±���¼
Requeset : {
    MSG : "PUT_toDoList"
    Data : {
        ISI   �� int     ���û�ʶ���룩
        id    :  int     ������¼�ǵڼ���)
        title : String  (����¼����)
        text  : String  (����¼����)
        src   : String  (ͼƬ�ļ���)
    }
}
Success Response : {
    MSG : "OK"
    Data : {
        
    }
}
errorCode    error
    0        δ֪����
    1        �Ҳ����ñ���¼
  
```

