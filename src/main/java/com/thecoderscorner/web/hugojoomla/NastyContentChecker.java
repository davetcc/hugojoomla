package com.thecoderscorner.web.hugojoomla;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NastyContentChecker {
    private final Logger logger = LoggerFactory.getLogger("HACKED-SITE-WARNING");
    public void checkForNastyContent(JoomlaContent c) {
        String toCheck = c.getIntro() + "\n" + c.getBody();
        if(toCheck.contains("eval") && (toCheck.contains("base64_decode") || toCheck.contains("gzinflate")) ) {
            logger.error("CAUTION: there is an eval script within your content, be careful before proceeding");
        }
    }
}
