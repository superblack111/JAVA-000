package top.yiwenlong.school;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootApplication
@SpringBootTest
class SpringBootStarterTest {

    @Resource
    private ISchool school;

    @Test
    void schoolTest() {
        school.show();
    }
}
