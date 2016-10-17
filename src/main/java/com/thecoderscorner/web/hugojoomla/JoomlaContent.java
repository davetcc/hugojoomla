package com.thecoderscorner.web.hugojoomla;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JoomlaContent {
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

    public JoomlaContent(int id, String author, LocalDate createdDate, String intro,
                         String body, String category, String title, String alias) {
        this.id = id;
        this.author = author;
        this.createdDate = createdDate;
        this.intro = intro;
        this.body = body;
        this.category = category;
        this.title = title;
        this.alias = alias;
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
}
