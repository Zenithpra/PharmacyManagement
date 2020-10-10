package com.foodmandu;

import com.foodmandu.bll.LoginBLL;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
class LoginTest {

    @Test
    public void testLogin()
    {
        LoginBLL loginBLL = new LoginBLL();
        Boolean result =loginBLL.checkUser("ZenithPrajapati", "Zenith");
        assertEquals(true, result);
    }
}


