/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author Khandaa
 */
public class Q23csv {

    public static void main(String[] args) throws TwitterException {
        // extract - read data from twitter
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("maGjE9qB3RTWWXvdrJYQcOKnK")
                .setOAuthConsumerSecret("4zTIgEO7gsPyS9EirBWPvCjoLyjYxPWO77k3gFYIdvV6BlcBk4")
                .setOAuthAccessToken("48235933-PfKSaIMnNYqWkiBVwvqSaebkCovIkWxar9XYyr5xv")
                .setOAuthAccessTokenSecret("tfSKcMsJiOBuxMZNqdTdtKYfcq9ZWTD7iimkCxEnTisRF");

        TwitterFactory tf = new TwitterFactory(cb.build());
        twitter4j.Twitter twitter = tf.getInstance();
        List<Status> status = twitter.getHomeTimeline();

        StringBuilder sb = new StringBuilder();
        sb.append("User,Text,Lang,CreatedAt,CurrentUserRetweetId,"
                + "FavoriteCount,GeoLocation,Id,InReplyToStatusId,InReplyToUserId,"
                + "Place,QuotedStatusId,RetweetCount,Source,SourceUrl,SourceValue");
        sb.append("\n");
        String[] arr;
        for (Status st : status) {
            // Field Guide - https://dev.twitter.com/overview/api/tweets
            if (!st.getUser().getName().isEmpty()) {
                sb.append(st.getUser().getName());
                sb.append(",");
                sb.append(String.valueOf(st.getText()).replace(",", ";")
                                                      .replace("\n", ""));
                sb.append(",");
                sb.append(st.getLang());
                sb.append(",");
                sb.append(st.getCreatedAt()); 
                sb.append(",");
                sb.append(st.getCurrentUserRetweetId());
                sb.append(",");
                sb.append(st.getFavoriteCount());
                sb.append(",");
                sb.append(st.getGeoLocation());
                sb.append(",");
                sb.append(st.getId());
                sb.append(",");
                sb.append(st.getInReplyToStatusId());
                sb.append(",");
                sb.append(st.getInReplyToUserId());
                sb.append(",");
                sb.append(String.valueOf(st.getPlace()).replace(",", ";"));
                sb.append(",");
                sb.append(String.valueOf(st.getQuotedStatusId()).replace(",", ";"));
                sb.append(",");
                sb.append(st.getRetweetCount());
                sb.append(",");
                sb.append(String.valueOf(st.getSource()).replace(",", ";"));
                sb.append(",");
                
                // transform - changes to some attributes
                arr = st.getSource().split("\"");
                sb.append(arr[1]);  // SourceUrl
                sb.append(",");
                sb.append(String.valueOf(arr[4]).replace(">", "") // SourceValue
                                                .replace("</a", ""));
                sb.append("\n");
            }
        }
        
        // load - export to file
        LocalDate localDate = LocalDate.now();
        String filename = "./data/" + DateTimeFormatter.ofPattern("MMMdd").format(localDate);
        
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            fw = new FileWriter(filename+".csv");
            bw = new BufferedWriter(fw);
            bw.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) bw.close();
                if (fw != null) fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }

    }

}
