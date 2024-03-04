# 💻 기초 알고리즘 스터디

## 📅 스터디 기간
- 2024년 2월 1일부터 화요일 ~ 금요일 알고리즘 스터디 시작
- 바킹독 강의 + 연습문제 풀이 : 2024년 02월 01일 ~ 2024년 02월 29일
- 프로그래머스 알고리즘 고득점 Kit : 2024년 03월 04일 ~ 2024년 06월 01일
  - 수요일까지 그 주에 해당하는 유형의 문제 1개씩 풀어온 후, 검색 없이 다시 풀기
  - 주어진 시간안에 서로의 문제를 바꿔 풀어보기
  - 각자 풀어온 문제를 상대방에게 설명하기
  - ***일요일까지 그 주에 푼 문제 2개 깃허브에 push***
  - 마지막 주에 3주간 풀어본 문제들을 검색이나 힌트없이 시간 내에 풀어보기

## 🎯 스터디 목표
- [바킹독의 실전 알고리즘](https://youtube.com/playlist?list=PLtqbFd2VIQv4O6D6l9HcD732hdrnYb6CY&feature=shared) 0x11강 - 그리디까지 완강하기
- [프로그래머스 알고리즘 고득점 Kit](https://school.programmers.co.kr/learn/challenges?tab=algorithm_practice_kit) - 그래프까지 각 유형 최소 2문제 이상 풀고 이해하기(5번 이상의 복습 목표)
- 기초적인 알고리즘 지식을 습득하고 코드에 적용해보기
- github에 익숙해지고 커밋 습관 만들기

## 📓 커밋 컨벤션
- 커밋 컨벤션을 준수하여 커밋메시지를 의미있게 작성한다.
- 해당 날짜에 풀어야 할 문제를 모두 풀고 한 번에 커밋한다.
- 타입, 강의 제목, 문제 분류를 적는다. ex) `add: 0x03강 - 배열 연습문제'
- `add` : 문제 풀이 or 추가했을 때
- `fix`: 문제 오류를 수정했을 때
- `remove` : 코드(파일) 삭제했을 때
- `rename` : 파일명을 변경했을 때
- `refactor` : 리팩토링 했을 때
- `test` : 문제 발생 시 테스트 커밋했을 때

## 🌱 스터디 초기 세팅
1. 자신의 이메일 계정으로 들어가서 Collaborator를 수락한다.
2. 터미널에서 다음과 같이 입력해 저장소를 `clone`한다.
```
git clone https://github.com/3uomlkh/algorithmStudy.git
```
3. 자신의 이름으로 브랜치를 생성한다.
```
git branch {브랜치이름}
```
4. 생성한 브랜치로 이동한다.
```
git checkout {브랜치이름}
```
5. IDE에서 저장소를 열고 `본인이름/강의 제목` 폴더에 파일을 생성해 코드를 작성한다.

## 🍀 스터디 진행방식
- 화요일 ~ 금요일동안 매일 강의 1개를 들은 후 연습 문제를 풀어 개인 브랜치에 `push`한다.
- `main` 브랜치로 `Pull requests`를 보낸다.
- `PR` 작성 시 제목은 이름, 월, 주차, 문제진도를 포함한다. ex) `[채원] 1월 1주차 연습 문제 풀이`
- 다른 사람의 코드를 보며 자유롭게 코드리뷰를 한다.
- 주말에 `채원`이 문제풀이 현황을 확인 후 `merge`한다.
- 새 주차가 시작되면 main 브랜치와의 싱크를 맞춘 후 문제를 푼다.
- 궁금한 점이 생기면 수요일 오프라인 스터디에서 의견을 나눈다.

## ⚠️ 주의할 점
- 굳이 올리지 않아도 될 파일이 올라가지 않도록 `gitignore`를 통해 관리한다.
- 반드시 자신의 브랜치로 이동 후 코드를 작성한다.
- `push`하기 전에 모든 문제를 풀었는지, 오류가 없는지 꼭 확인한다.
- 파일명은 문제명으로 하되, 띄어쓰기는 `_`으로 바꾼다. ex) `X보다_작은_수`
