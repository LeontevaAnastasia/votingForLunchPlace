package com.votingforlunch.ServiceTests;

import com.votingforlunch.util.ValidationUtil;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@RunWith(SpringRunner.class)
public abstract class AbstractServiceTest {

    //  Check root cause in JUnit: https://github.com/junit-team/junit4/pull/778
    protected <T extends Throwable> void validateRootCause(Runnable runnable, Class<T> rootExceptionClass) {
        assertThrows(rootExceptionClass, () -> {
            try {
                runnable.run();
            } catch (Exception e) {
                throw ValidationUtil.getRootCause(e);
            }
        });
    }
}
