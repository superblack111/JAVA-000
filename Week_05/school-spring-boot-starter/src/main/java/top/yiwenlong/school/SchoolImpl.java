package top.yiwenlong.school;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SchoolImpl implements ISchool {

    private String name;
    private String level;
    private String location;

    @Override
    public void show() {
        System.out.println(toString());
    }
}
