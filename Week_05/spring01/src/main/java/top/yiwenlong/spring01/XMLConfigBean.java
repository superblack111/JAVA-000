package top.yiwenlong.spring01;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Data
@NoArgsConstructor
@ToString
@Slf4j
public class XMLConfigBean implements Serializable {

    private int id;
    private String name;

    public void hello() {
        log.info(this.toString());
    }
}
