/*
    플랫폼 / 문제번호 / 문제이름
    Status: v1
    Key:
    Notes:
    Last Reviewed: 2025-00-00
*/
package SWEA.D2.P1979;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[][] arr = new int[N][N];

            // 입력 (인덱스 버그 수정)
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int totalCount = 0;

            // =====================
            // 가로 체크
            // =====================
            for (int i = 0; i < N; i++) {
                int count = 0;

                for (int j = 0; j < N; j++) {
                    if (arr[i][j] == 1) {
                        count++;
                    } else {
                        if (count == K) {
                            totalCount++;
                        }
                        count = 0;
                    }
                }

                // 줄 끝에서 연속 길이 체크
                if (count == K) {
                    totalCount++;
                }
            }

            // =====================
            // 세로 체크
            // =====================
            for (int j = 0; j < N; j++) {
                int count = 0;

                for (int i = 0; i < N; i++) {
                    if (arr[i][j] == 1) {
                        count++;
                    } else {
                        if (count == K) {
                            totalCount++;
                        }
                        count = 0;
                    }
                }

                // 열 끝에서 연속 길이 체크
                if (count == K) {
                    totalCount++;
                }
            }

            System.out.println("#" + t + " " + totalCount);
        }
    }
}