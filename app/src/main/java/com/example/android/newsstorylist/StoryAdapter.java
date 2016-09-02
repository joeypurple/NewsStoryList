package com.example.android.newsstorylist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by joe on 02/09/2016.
 */
public class StoryAdapter extends ArrayAdapter<Story> {

    private static final String TIME_SEPARATOR = "T";

    /**
     * Constructs a new {@link StoryAdapter}.
     *
     * @param context of the app
     * @param stories is the list of stories, which is the data source of the adapter
     */
    public StoryAdapter(Context context, List<Story> stories) {
        super(context, 0, stories);
    }

    /**
     * Returns a list item view that displays information about the story at the given position
     * in the list of stories.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        /**
         * Check if there is an existing list item view (called convertView) that we can reuse,
         * otherwise, if convertView is null, then inflate a new list item layout.
         */
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.story_list_item, parent, false);
        }

        //Find the story at the given position in the list of stories
        Story currentStory = getItem(position);

        //Get the title string from the story object
        String webTitle = currentStory.getTitle();

        //Get the category string from the story object
        String sectionName = currentStory.getCategory();


        String originalTime = currentStory.getTime();
        String splitDate;
        String splitTime;
        String hour;
        String minute;

        String[] parts = originalTime.split(TIME_SEPARATOR);
        splitTime = parts[1];
        splitDate = parts[0];

        String[] partsTwo = splitTime.split(":");
        hour = partsTwo[0];
        minute = partsTwo[1];

        String newTime = hour + ":" + minute;

        // Create a new Date object from the time in milliseconds of the story
//        Date dateObject = new Date(currentStory.getTime());

        //Find the TextView with view ID title
        TextView titleView = (TextView) listItemView.findViewById(R.id.web_title);
        //Display the title of the current story in that TextView
        titleView.setText(webTitle);

        //Find the TextView with view ID section name
        TextView categoryView = (TextView) listItemView.findViewById(R.id.section_name);
        //Disp;ay the category of the current story in that Text View
        categoryView.setText(sectionName);

        //Find the TextView with the view ID date
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        //Format the date string (ie. "Mar 3, 1984"
 //       String formattedDate = formatDate(dateObject);
        //Display the time of the current story in that TextView
        dateView.setText(splitDate);

        //Find the TextView with the view ID time
        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        //Format the time string (ie. "4:30 PM)
//        String formattedTime = formatTime(dateObject);
        //Dislay the time of the current story in that TextView
        timeView.setText(newTime);

        //Return the list item view that is now showing the appropriate data
        return listItemView;

    }
    
}
