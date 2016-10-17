package com.thecoderscorner.web.hugojoomla;

import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JoomlaContent {
    private final static Logger LOGGER = LoggerFactory.getLogger(JoomlaContent.class);

    private final static Pattern HYPERLINK_PATTERN = Pattern.compile("\\<a[^\\>]*\\>([^\\<]*)\\<\\/a\\>");
    private final static DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
    private final int id;
    private final String author;
    private final LocalDate createdDate;
    private final String intro;
    private final String body;
    private final String category;
    private final String title;
    private final String alias;
    private JoomlaImage introImage = JoomlaImage.EMPTY;
    private JoomlaImage bodyImage = JoomlaImage.EMPTY;

    public JoomlaContent(int id, String author, LocalDate createdDate, String intro,
                         String body, String category, String title, String alias,
                         String images) {
        this.id = id;
        this.author = author;
        this.createdDate = createdDate;
        this.intro = intro;
        this.body = body;
        this.category = category;
        this.title = title;
        this.alias = alias;
        try {
            introImage = new JoomlaImage("intro", images);
            bodyImage = new JoomlaImage("fulltext", images);
        } catch (ParseException e) {
            LOGGER.warn("Images for " + id +" not processed",e);
        }
    }

    public String getAlias() {
        return alias;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getCreatedDateAsText() {
        return formatter.format(createdDate);
    }

    public String getIntro() {
        return intro;
    }

    public String getIntroAsSingleLine() {
        return escapeIt(intro);
    }

    public String escapeIt(String s) {
        s = s.replaceAll("[\\n\\r]*", "");
        s = s.replace("\"", "\\\"");
        return removeAllHyperlinks(s.replace("\'", "\\\""));
    }

    public String removeAllHyperlinks(String s) {
        boolean foundHyperlink = true;
        while(foundHyperlink) {
            Matcher linkMatcher = HYPERLINK_PATTERN.matcher(s);
            if(linkMatcher.find()) {
                String searchStr = linkMatcher.group(0);
                String replacement = linkMatcher.group(1);
                s = s.replace(searchStr, replacement);
                LOGGER.info("Hyperlink removal in introduction for " + searchStr);
            }
            else {
                foundHyperlink = false;
            }
        }
        return s;
    }

    public String getBody() {
        return body;
    }

    public String getCategory() {
        return category;
    }

    public String getTitle() {
        return escapeIt(title);
    }

    public JoomlaImage getIntroImage() {
        return introImage;
    }

    public JoomlaImage getBodyImage() {
        return bodyImage;
    }
}
