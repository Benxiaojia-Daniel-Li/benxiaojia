
package com.awesome.benxiaojia.model;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;
@Data
public class Model implements Serializable {
    [# th:each="item : ${name}"][# th:if="${item.key=='name'}"]
     private Long [[${item.value}]] ;
    [/] [/]
}
