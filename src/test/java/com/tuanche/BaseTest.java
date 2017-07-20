package com.tuanche;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2017/7/12.
 */@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:/spring/*.xml"})

public abstract class BaseTest {
}
