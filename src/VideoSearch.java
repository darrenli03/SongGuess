import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.*;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

public class VideoSearch {
    PlaylistItemListResponse playlistResponse;

    /**
     * Initializes a VideoSearch object that uses the YouTube API to get a list of videos from the playlist specified by String playlistId.
     */
    public VideoSearch() throws IOException, GeneralSecurityException {
        String apiKey = "AIzaSyDJ_iUELWlmMNW6qSXO9FdBDZGmu65oUzs"; // YouTube API key for authenticating the request
        String playlistId = "PLMC9KNkIncKtGvr2kFRuXBVmBev6cAJ2u"; // playlist ID to retrieve videos from

        // Initializing the YouTube Data API service
        YouTube youtubeService = new YouTube.Builder(
                GoogleNetHttpTransport.newTrustedTransport(),
                JacksonFactory.getDefaultInstance(),
                null
        ).setApplicationName("YouTubePlaylistPlayer").build();

        // Define the playlist items request
        YouTube.PlaylistItems.List playlistItemsRequest = youtubeService.playlistItems()
                .list(Collections.singletonList("snippet"));
        playlistItemsRequest.setKey(apiKey);
        playlistItemsRequest.setPlaylistId(playlistId);
        playlistItemsRequest.setMaxResults(50L); // Set the number of videos to retrieve, max 50

        // Execute the playlist items request
        playlistResponse = playlistItemsRequest.execute();
    }

    /**
     * Takes the videos from class variable playlistResponse and puts each video's ID and title into a HashMap
     *
     * @return a HashMap in which the keys are Strings that represents a video ID and their corresponding values are Strings that represents the video's title
     */
    public HashMap<String, String> getVideoMap() {
        HashMap<String, String> output = new HashMap<>();

        for (int i = 0; i < playlistResponse.getItems().size(); i++) {
            PlaylistItem videoItem = playlistResponse.getItems().get(i);
            String videoTitle = videoItem.getSnippet().getTitle();
            String videoId = videoItem.getSnippet().getResourceId().getVideoId();
            output.put(videoId, videoTitle);

        }

        return output;
    }

    public String getVideoID(int playlistItemNumber) {
        PlaylistItem videoItem = playlistResponse.getItems().get(playlistItemNumber);

        String videoID = videoItem.getSnippet().getResourceId().getVideoId();

        return videoID;
    }

    public String getVideoTitle(int playlistItemNumber) {

        PlaylistItem videoItem = playlistResponse.getItems().get(playlistItemNumber);

        // Retrieve video details
        String videoTitle = videoItem.getSnippet().getTitle();

        return videoTitle;
    }

    public String getVideoURL(int playlistItemNumber) {
        PlaylistItem videoItem = playlistResponse.getItems().get(playlistItemNumber);

        String videoId = videoItem.getSnippet().getResourceId().getVideoId();
        String videoURL = "https://www.youtube.com/watch?v=" + videoId;

        return videoURL;
    }

    /*
    public static void main(String[] args) {
        try {
            String apiKey =  "AIzaSyDJ_iUELWlmMNW6qSXO9FdBDZGmu65oUzs"; // Replace with your YouTube API key
            String playlistId = "PLMC9KNkIncKtGvr2kFRuXBVmBev6cAJ2u"; // Replace with the playlist ID you want to retrieve videos from

            // Initialize the YouTube Data API service
            YouTube youtubeService = new YouTube.Builder(
                    GoogleNetHttpTransport.newTrustedTransport(),
                    JacksonFactory.getDefaultInstance(),
                    null
            ).setApplicationName("YouTubePlaylistPlayer").build();

            // Define the playlist items request
            YouTube.PlaylistItems.List playlistItemsRequest = youtubeService.playlistItems()
                    .list(Collections.singletonList("snippet"));
            playlistItemsRequest.setKey(apiKey);
            playlistItemsRequest.setPlaylistId(playlistId);
            playlistItemsRequest.setMaxResults(1L); // Set the number of videos to retrieve

            // Execute the playlist items request and get the first video
            PlaylistItemListResponse playlistResponse = playlistItemsRequest.execute();
            PlaylistItem videoItem = playlistResponse.getItems().get(0);

            // Retrieve video details
            String videoTitle = videoItem.getSnippet().getTitle();
            String videoId = videoItem.getSnippet().getResourceId().getVideoId();

            // Print video details (for demonstration)
            System.out.println("Video Title: " + videoTitle);
            System.out.println("Video ID: " + videoId);

            String videoUrl = "https://www.youtube.com/watch?v=" + videoId;

            // Open the video URL and retrieve the video stream
            URL url = new URL(videoUrl);
            InputStream stream = url.openStream();

            // Create an AdvancedPlayer instance and play the video
            AdvancedPlayer player = new AdvancedPlayer(stream);

            System.out.println("Playing video: " + videoUrl);
            player.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
*/
}
