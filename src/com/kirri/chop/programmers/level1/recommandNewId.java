package com.kirri.chop.programmers.level1;

import java.util.Scanner;

public class recommandNewId {
    public static String recommandNewId(String new_id) {
        String answer = "";
        String output = "";
         int tmp;
         //char charTmp;

         //1단계
        for(int i = 0; i < new_id.length(); i++) {
            tmp = new_id.charAt(i);
            if(65 <= tmp && tmp <= 90) {
                answer += (char)(tmp + 32);
            } else {
                answer += (char)tmp;
            }
        }

//        for(int i = 0; i < new_id.length(); i++) {
//            tmp = new_id.charAt(i);
//            if(Character.isUpperCase(tmp)) { //대문자인 경우
//                answer += (char)(tmp + 32);
//            } else { //97~120은 소문자
//                answer += tmp;
//            }
//        }

        //2단계
        for(int i = 0; i < answer.length(); i++) {
            tmp = answer.charAt(i);
            char charTmp = (char)tmp;
            if((48 <= tmp && tmp <= 57) || (97 <= tmp && tmp <= 120) || charTmp == '-' || charTmp == '_' || charTmp == '.')
                output += charTmp;
        }
        answer = output;

        //3단계


//        1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
//        2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
//        3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
//        4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
//        5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
//        6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
//                만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
//        7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        return answer;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("text:");
        String input = stdIn.next();

        System.out.println(recommandNewId(input));
    }
}