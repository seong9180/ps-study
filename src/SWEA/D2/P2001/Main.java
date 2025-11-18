/*
    플랫폼 / 문제번호 / 문제이름
    Status: v1
    Key: 복잡한 입출력 시, StringTokenizer 활용에 유의할 것
    + for문 인덱스 실수가 잦기 때문에 실전에서는 좀 더 꼼꼼히 확인할 필요
    + 에러코드 발생 시 분석하는 습관 들이기ㅡ gpt 도움을 최대한 지양하기
    Notes:
    Last Reviewed: 2025-11-18
*/
package SWEA.D2.P2001;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // TODO: solve
        /*
        flow
        1. for 문 범위 설정으로 가능한 모든 파리채 구역 완전탐색
        2. 완전탐색 후 저장된 내부 값의 합 최대값을 저장
            -> 내부 최대값을 더하는 과정을 어디에 넣어야 하는지.
         */

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] arr = new int[N][N];

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());  //재할당. 제일 중요한 포인트
                for (int k = 0; k < N; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            int max = 0;
            for (int j = 0; j <= N - M; j++) {
                for (int k = 0; k <= N - M; k++) {
                    //M*M 파리채의 시작점 (좌측상단)
                    int count = 0;
                    for (int x = j; x < j + M; x++) {
                        for (int y = k; y < k + M; y++) {
                            count += arr[x][y];
                        }
                    }
                    max = Math.max(count, max);
                }
            }
            System.out.println("#" + (i + 1) + " " + max);
        }
    }
}