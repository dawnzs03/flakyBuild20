package cn.tuyucheng.taketoday.patterns.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Contact {

    private String type;
    private String detail;

}
