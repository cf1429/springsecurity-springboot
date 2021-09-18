package com.cn;

import org.junit.runner.RunWith;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author:chenf
 * @Date:2021/9/18 10:54
 * @describe
 */
@RunWith(SpringRunner.class)
public class Test {
    @org.junit.Test
    public void testBcrypt(){
        String gensalt = BCrypt.gensalt();
        System.out.println("密码加密盐"+gensalt);  // $2a$10$Ixc42hQXca5tiy7sWRf1H.gjpvL6OnmSVY1K/H7Hg4Rvsy0b/uh7S

        String hashpw = BCrypt.hashpw("123", gensalt);

        System.out.println(hashpw);

    }
}
