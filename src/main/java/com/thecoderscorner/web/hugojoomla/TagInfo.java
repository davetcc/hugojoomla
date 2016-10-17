package com.thecoderscorner.web.hugojoomla;

class TagInfo {
    private final String tagName;
    private final int contentId;

    public TagInfo(String tagName, int contentId) {
        this.tagName = tagName;
        this.contentId = contentId;
    }

    public int getContentId() {
        return contentId;
    }

    public String getTagName() {
        return tagName;
    }
}
