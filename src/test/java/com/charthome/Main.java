package com.charthome;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char [][] board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = String.valueOf(br.readLine()).toCharArray();
        }
        int min = 64;
        for(int i = 0 ; i < N - 7 ; i++) { // 세로의 경우의 수
            for(int j = 0 ; j < M - 7 ; j++) { // 가로의 경우의 수
                min = Math.min(min, cal(i, j, board)); // 최소값을 저장
            }
        }
        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
    }
    static int cal(int x, int y, char[][]board){
        int count = 0;

        char color = 'W'; // 첫번째 칸을 W를 기준으로 색칠
        for(int i = x ; i < x + 8 ; i++) { // 시작컬럼부터 8개까지
            for(int j = y ; j < y + 8 ; j++) { //시작컬럼부터 8개까지
                // color는 정상적인 체스판이고 WB[i][j]와 비교
                if(board[i][j] != color) {
                    count++;
                }
                if(color == 'W') { // 컬러 변경
                    color = 'B';
                }else {
                    color = 'W';
                }
            }
            if(color == 'W') { // 줄이 바뀌면 바로 윗칸과 색깔이 달라야 함
                color = 'B';
            }else {
                color = 'W';
            }
        }
         count = Math.min(count, 64 - count);
        return count;
    }
}
