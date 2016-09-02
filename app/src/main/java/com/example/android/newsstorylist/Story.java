package com.example.android.newsstorylist;

/**
 * Created by joe on 02/09/2016.
 */
public class Story {

    //Title of the story
    private String mTitle;

    //Category of the story
    private String mCategory;

    //Time of the story
    private String mTime;

    //Website URL of the story
    private String mUrl;

    /**
     * Constructs a new {@link Story} object.
     *
     * @param title is the title of the story
     * @param category is the name of the section of the story
     * @param time is the time  from the Epoch when the story was published
     * @param url is the website URL to find the full story
     *
     */
    public Story(String title, String category, String time, String url) {
        mTitle = title;
        mCategory = category;
        mTime = time;
        mUrl = url;
    }

    //Returns the title of the story
    public String getTitle() {
        return mTitle;
    }


    public String getCategory() {
        return mCategory;
    }

    public String getTime() {
        return mTime;
    }

    public String getUrl() {
        return mUrl;
    }
}
