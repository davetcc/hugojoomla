package com.thecoderscorner.web.hugojoomla;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HugoJoomla {
    private final static Logger LOGGER = LoggerFactory.getLogger(HugoJoomla.class);

    public static void main(String[] args) {
        try {
            Options options = new Options();
            options.addOption("dburl", true, "the MySQL JDBC url of the db");
            options.addOption("dbuser", true, "the MySQL user name");
            options.addOption("dbpass", true, "the MySQL password");
            options.addOption("outdir", true, "output directory");
            options.addOption("dbext", true, "database extension");
            options.addOption("buildtags", true, "if true, process tags, otherwise do not process");

            CommandLineParser parser = new DefaultParser();
            CommandLine cmd = parser.parse(options, args);
            System.setProperty("db.url", cmd.getOptionValue("dburl"));
            System.setProperty("db.user", cmd.getOptionValue("dbuser"));
            System.setProperty("db.pass", cmd.getOptionValue("dbpass"));
            System.setProperty("out.dir", cmd.getOptionValue("outdir", "."));
            System.setProperty("category.action", cmd.getOptionValue("cataction", "TOPONLY"));
            System.setProperty("db.ext", cmd.getOptionValue("dbext"));
            System.setProperty("buildtags", cmd.getOptionValue("buildtags", "true"));

            ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("hugoJoomla.xml");
            ctx.getBean("joomlaHugoConverter", JoomlaHugoConverter.class).performConversion();
        }
        catch(Exception ex) {
            LOGGER.error("Unable to start conversion process.", ex);
        }
    }
}
