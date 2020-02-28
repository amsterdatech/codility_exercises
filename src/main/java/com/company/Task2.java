package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {

    private Pattern regex = Pattern.compile("([a-z]*)([0-9])([a-z]*)");
    private Map<String, Integer> summaryResults = new HashMap<String, Integer>();

    private int groupCount = 0;
    private int correctAnswers = 0;


    public static void main(String[] args) {

    }

    public int solution(String[] T, String[] R) {
        extractGroupNames(T);
        processCorrectAnswers(T, R);

        return (correctAnswers * 100) / groupCount;

    }

    private void processCorrectAnswers(String[] T, String[] R) {
        for (int i = 0; i < R.length; i++) {
            if (R[i].equals("OK")) {

                String groupName = parseTestName(T[i]);
                int score = summaryResults.get(groupName);

                summaryResults.put(groupName, score - 1);
            }
        }

        for (String key : summaryResults.keySet()) {
            if (summaryResults.get(key) == 0) {
                correctAnswers++;
            }
        }
    }

    private void extractGroupNames(String[] T) {
        for (String testName : T) {
            String indexGroup = parseTestName(testName);
            if (summaryResults.containsKey(indexGroup)) {
                summaryResults.put(indexGroup, summaryResults.get(indexGroup) + 1);
            } else {
                summaryResults.put(indexGroup, 1);
            }
        }

        groupCount = summaryResults.size();
    }

    private String parseTestName(String rawTestName) {
        Matcher matcher = regex.matcher(rawTestName);
        if (matcher.find()) {
            return matcher.group(2);
        }
        return null;
    }
    /**
     * Previous solution created during test on codility platform
     *
     *
     * class Solution {
     *     private int groupsCount = 0;
     *     private int groupsPassed = 0;
     *     private int lastTestGroup = 0;
     *     private boolean flagResult = false;
     *
     *     private Pattern regex = Pattern.compile("([a-z]*)([0-9])([a-z]*)");
     *     public int solution(String[] T, String[] R) {
     *
     *        for(int i = 0;i < R.length;i++){
     *            String result = R[i];
     *            String testName = T[i];
     *            Matcher matcher = regex.matcher(testName);
     *            if(matcher.find()){
     *                int testGroup = Integer.parseInt(matcher.group(2));
     *                if(matcher.group(3).isEmpty()){
     *                    if(result.equals("OK")){
     *                        groupsPassed++;
     *                    }
     *                 groupsCount++;
     *                 lastTestGroup = testGroup;
     *
     *                }else{
     *                   if(lastTestGroup != testGroup){
     *                       if(flagResult){
     *                          groupsPassed++;
     *                       }
     *                       groupsCount++;
     *                       lastTestGroup = testGroup;
     *                   }else{
     *                     flagResult &= result.equals("OK");
     *                   }
     *                }
     *            }
     *
     *
     *        }
     *
     *        System.out.println("Passed:" + groupsPassed);
     *        System.out.println("Count:" + groupsCount);
     *
     *        return (groupsPassed * 100) /groupsCount ;
     *
     *     }
     * }
     *
     *
     */
}
