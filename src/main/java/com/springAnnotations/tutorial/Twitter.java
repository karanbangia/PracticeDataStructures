//package com.springAnnotations.tutorial;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.PriorityQueue;
//
//class TweetDetails
//{
//    private int user;
//    private int tweet;
//
//    public LocalDateTime getTweetTime() {
//        return tweetTime;
//    }
//
//    public void setTweetTime(LocalDateTime tweetTime) {
//        this.tweetTime = tweetTime;
//    }
//
//    private LocalDateTime tweetTime;
//
//    public TweetDetails(int user, int tweet, LocalDateTime time) {
//        this.user = user;
//        this.tweet = tweet;
//        this.tweetTime = time;
//    }
//
//    public int getUser() {
//        return user;
//    }
//
//    public void setUser(int user) {
//        this.user = user;
//    }
//
//    public int getTweet() {
//        return tweet;
//    }
//
//    public void setTweet(int tweet) {
//        this.tweet = tweet;
//    }
//}
//class User
//{
//    private int user;
//    private List<Integer> tweets=new ArrayList<>();
//    private List<Integer> follower=new ArrayList<>();
//    private List<Integer> following=new ArrayList<>();
//    private PriorityQueue<TweetDetails> pq=new PriorityQueue<>((o1,o2)->{
//        if(o1.getTweetTime().isAfter(o2.getTweetTime()))
//        {
//            return -1;
//        }
//        else if (o1.getTweetTime().isBefore(o2.getTweetTime()))
//        {
//            return 1;
//        }
//        else return 0;
//    });
//
//    public User(int user,int tweetId) {
//        this.user = user;
//        tweets.add(tweetId);
//        pq.add(new TweetDetails(user,tweetId, LocalDateTime.now()));
//    }
//
//    public User(int user) {
//        this.user = user;
//    }
//
//    public int getUser() {
//        return user;
//    }
//
//    public void setUser(int user) {
//        this.user = user;
//    }
//
//    public List<Integer> getTweet() {
//        return tweets;
//    }
//
//    public void setTweet(int tweetId) {
//        tweets.add(tweetId);
//    }
//
//    public List<Integer> getFollower() {
//        return follower;
//    }
//
//    public void setFollower(int followerId) {
//        this.follower.add(followerId);
//    }
//
//    public void removeFollower(int followerId) {
//        this.follower.remove(followerId);
//    }
//
//    public List<Integer> getFollowing() {
//        return following;
//    }
//
//    public void setFollowing(int followingId) {
//        this.following.add(followingId);
//    }
//
//    public void removeFollowing(int followingId) {
//        this.following.remove(followingId);
//    }
//
//    public PriorityQueue<TweetDetails> getPq() {
//        return pq;
//    }
//
//}
//public class Twitter {
//    HashMap<Integer,User> users;
//    public Twitter() {
//        users=new HashMap<>();
//    }
//
//    /** Compose a new tweet. */
//    public void postTweet(int userId, int tweetId) {
//       if(!users.containsKey(userId))
//       {
//           users.put(userId,new User(userId,tweetId));
//       }
//       else {
//           User currUser= users.get(userId);
//           currUser.setTweet(tweetId);
//       }
//    }
//
//    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
//    public List<Integer> getNewsFeed(int userId) {
//
//    }
//
//    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
//    public void follow(int followerId, int followeeId) {
//        if(!users.containsKey(followerId))
//        {
//            users.put(followerId,new User(followerId));
//        }
//        if(!users.containsKey(followeeId))
//        {
//            users.put(followeeId,new User(followeeId));
//
//        }
//        User follower=users.get(followerId);
//        User followee=users.get(followeeId);
//        follower.setFollowing(followeeId);
//        followee.setFollower(followerId);
//    }
//
//    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
//    public void unfollow(int followerId, int followeeId) {
//        if(!users.containsKey(followeeId) || !users.containsKey(followerId))
//        {
//            return;
//        }
//        User follower=users.get(followerId);
//        User followee=users.get(followeeId);
//        follower.removeFollowing(followeeId);
//        followee.removeFollower(followerId);
//
//    }
//}
