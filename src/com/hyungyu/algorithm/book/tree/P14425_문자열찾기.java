package com.hyungyu.algorithm.book.tree;

import java.util.Scanner;

public class P14425_문자열찾기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 집합 S에 포함된 문자열 개수
        int N = sc.nextInt();
        // 검사해야 하는 문자열 개수
        int M = sc.nextInt();
        // root 노드 선언 및 초기화
        Node root = new Node();
        // 트라이 자료구조 구축
        for (int k = 0; k < N; k++) {
            // 문자열 입력
            String word = sc.next();
            // 입력 받은 단어 char 배열로 변환
            char[] wordCharacters = word.toCharArray();
            // 문자열 개수 추출
            int wordLength = wordCharacters.length;
            // 부모 노드 설정
            Node current = root;
            for (int i = 0; i < wordLength; i++) {
                // 알파벳 index 조회
                int wordIndex = wordCharacters[i] - 'a';
                if (current.checkChildNullWithIndex(wordIndex)) {
                    // 알파벳 index 에 해당하는 트라이 노드가 존재하지 않으면 선언 후 초기화
                    current.setNextChildWithIndex(wordIndex);
                }
                // 알파벳 index 에 해당하는 트라이 노드 를 부모 노드로 설정
                current = current.getNextChildWithIndex(wordIndex);

                if (i == wordLength - 1) {
                    // 마지막 인덱스의 단어는 end 표시
                    current.setEndFlag(true);
                }
            }
        }
        int count = 0;
        // 트라이 자료구조 검색
        for (int k = 0; k < M; k++) {
            // 문자열 입력
            String word = sc.next();
            // 입력 받은 단어 char 배열로 변환
            char[] wordCharacters = word.toCharArray();
            // 문자열 개수 추출
            int wordLength = wordCharacters.length;
            // 부모 노드 설정
            Node current = root;
            for (int i = 0; i < wordLength; i++) {
                // 알파벳 index 조회
                int wordIndex = wordCharacters[i] - 'a';
                if (current.checkChildNullWithIndex(wordIndex)) {
                    // 검색하는 단어가 트라이에 존재하지 않으면 없는 단어 이므로 검색 종료
                    break;
                }
                // 알파벳 index 에 해당하는 트라이 노드 를 부모 노드로 설정
                current = current.getNextChildWithIndex(wordIndex);
                if (i == wordLength - 1 && current.isEndFlag()) {
                    // 단어의 끝까지 검색 성공 했을 경우 S 집합에 포함되는 단어 이므로 count++
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static class Node {
        private Node[] next = new Node[26]; // 알파벳 자리수 만큼 배열 선언
        private boolean endFlag;

        public boolean checkChildNullWithIndex(int index) {
            return this.next[index] == null;
        }

        public void setNextChildWithIndex(int index) {
            this.next[index] = new Node();
        }

        public Node getNextChildWithIndex(int index) {
            return this.next[index];
        }

        public Node[] getNext() {
            return this.next;
        }

        public boolean isEndFlag() {
            return this.endFlag;
        }

        public void setEndFlag(boolean endFlag) {
            this.endFlag = endFlag;
        }
    }
}
