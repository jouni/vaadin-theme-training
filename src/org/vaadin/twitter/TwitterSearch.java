package org.vaadin.twitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class TwitterSearch {
    private static final long DEFAULT_ID = -1;
    private Query query;
    private long sinceId;
    private long maxId;

    public TwitterSearch(String search) {
        query = new Query(search);
        reset();
    }

    /**
     * Clears the search and resets the paging.
     */
    public void reset() {
        sinceId = DEFAULT_ID;
        maxId = DEFAULT_ID;
    }

    /**
     * Gets older tweets.
     */
    public List<Tweet> more() {
        setQueryRange(DEFAULT_ID, maxId);
        List<Tweet> tweets = search(query);
        if (tweets.size() > 0) {
            maxId = maxId(tweets);
            if (sinceId == DEFAULT_ID) {
                sinceId = sinceId(tweets);
            }
        }
        return tweets;
    }

    /**
     * Gets newer tweets.
     */
    public List<Tweet> latest() {
        setQueryRange(sinceId, DEFAULT_ID);
        List<Tweet> tweets = search(query);
        if (tweets.size() > 0) {
            sinceId = sinceId(tweets);
            if (maxId == DEFAULT_ID) {
                maxId = maxId(tweets);
            }
        }
        return tweets;
    }

    private void setQueryRange(long since, long max) {
        query.setSinceId(since);
        query.setMaxId(max);
    }

    @SuppressWarnings("unchecked")
    private List<Tweet> search(Query q) {
        if (q.getQuery().isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        List<Tweet> tweets = new ArrayList<Tweet>();
        for (int i = 0; i < 15; i++) {
            tweets.add(new Tweet());
        }
        return tweets;
    }

    private long maxId(List<Tweet> tweets) {
        return tweets.get(tweets.size() - 1).getId() - 1;
    }

    private long sinceId(List<Tweet> tweets) {
        return tweets.get(0).getId();
    }

    public static class Tweet {
        private static final String[] loremIpsum = { "lorem", "ipsum", "dolor",
                "sit", "amet", "consectetur", "adipisicing", "elit", "sed",
                "do", "eiusmod", "tempor", "incididunt", "ut", "labore", "et",
                "dolore", "magna", "aliqua", "ut", "enim", "ad", "minim",
                "veniam", "quis", "nostrud", "exercitation", "ullamco",
                "laboris", "nisi", "ut", "aliquip", "ex", "ea", "commodo",
                "consequat", "duis", "aute", "irure", "dolor", "in",
                "reprehenderit", "in", "voluptate", "velit", "esse", "cillum",
                "dolore", "eu", "fugiat", "nulla", "pariatur", "excepteur",
                "sint", "occaecat", "cupidatat", "non", "proident", "sunt",
                "in", "culpa", "qui", "officia", "deserunt", "mollit", "anim",
                "id", "est", "laborum" };
        private static int lastId = 0;

        private int id;
        private String text;

        Tweet() {
            id = lastId++;
            StringBuilder builder = new StringBuilder();
            double length = 2 + new Random().nextInt(138);

            System.out.println(length);

            while (builder.length() <= length) {
                builder.append(loremIpsum()).append(' ');
            }
            text = builder.substring(0, builder.lastIndexOf(" "));
        }

        public int getId() {
            return id;
        }

        /**
         * The name of the user that posted this tweet.
         */
        public String getFromUser() {
            return loremIpsum();
        }

        private String loremIpsum() {
            return loremIpsum[new Random().nextInt(loremIpsum.length)];
        }

        /**
         * The date on which this tweet was posted.
         */
        public Date getCreatedAt() {
            return new Date();
        }

        /**
         * Gets the message body of this tweet.
         */
        public String getText() {
            return text;
        }
    }

    private static class Query {

        private String searchString;

        Query(String query) {
            searchString = query;
        }

        public void setSinceId(long since) {
            // stubbed out
        }

        public void setMaxId(long max) {
            // stubbed out
        }

        public String getQuery() {
            return searchString;
        }
    }
}
