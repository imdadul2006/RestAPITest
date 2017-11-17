package com.RestApi.www;

public class ApiResource {

    public static String baseURL(){
        return "http://10.10.1.99:8080";
    }
    public static String getLogin(){
        return "/rest/auth/1/session";
    }
    public static String createIssuePost(){
        return "/rest/api/2/issue";
    }
    public static String addCommentPost(String key) {
        return "/rest/api/2/issue/"+key +"/comment";
    }
    public static String getComments(String issueIdOrKey){
        return  "/rest/api/2/issue/"+issueIdOrKey+"/comment";
    }
    public static String updateCommentPost(String issueIdOrKey, String id){
        return  "/rest/api/2/issue/"+issueIdOrKey+"/comment/"+ id;
    }
    public static String deleteCommentDelete(String issueIdOrKey, String id) {
        return "/rest/api/2/issue/"+ issueIdOrKey+ "/ comment /" +id;
    }
    public static String getComment(String issueIdOrKey,String id) {
        return "/rest/api/2/issue/" + issueIdOrKey + "/comment/" + id;
    }
    public static String searchPostGet(){
        return "/rest/api/2/search";
    }
    public static String createProject(){
        return "/rest/api/2/project";
    }




}
