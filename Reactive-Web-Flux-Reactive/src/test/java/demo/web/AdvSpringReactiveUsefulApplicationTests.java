package demo.web;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@Log4j2
@SpringBootTest
class AdvSpringReactiveUsefulApplicationTests {

    @Test
    void contextLoads() {
        log.info("Hello Junit5 test");
        assertTrue(true);
    }

}
