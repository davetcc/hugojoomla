package com.thecoderscorner.web.hugojoomla;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HugoJoomla {
    private final static Logger LOGGER = LoggerFactory.getLogger(HugoJoomla.class);

    public static void main(String[] args) {
        try {
            ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("hugoJoomla.xml");
            ctx.getBean("joomlaHugoConverter", JoomlaHugoConverter.class).performConversion();
        }
        catch(Exception ex) {
            LOGGER.error("Unable to start conversion process.", ex);
        }
    }
}
