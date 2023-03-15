# TreeReplay


## 구현 방법
```java
  //ID 검색
  private final Map<Long, Category> categoryIdMap = new ConcurrentHashMap<>();
  //이름 검색
  private final Map<String, Map<Long, Category>> categoryNameMap = new ConcurrentHashMap<>();
```

두개의 맵을 이용해서 요구사항에 있는 부모 id ,자식 id 를 이용해서 재귀적으로 replay 할 수 있도록 구현
- Json 출력 예시
ex)
```json
 {
  "id": 1,
  "name": "남자",
  "isLeafNode": false,
  "childCategory": [
    {
      "id": 2,
      "name": "엑소",
      "parentId": 1,
      "isLeafNode": false,
      "childCategory": [
        {
          "id": 3,
          "name": "공지사항",
          "boardName": "1",
          "parentId": 2,
          "isLeafNode": true,
          "childCategory": []
        },
        {
          "id": 4,
          "name": "첸",
          "boardName": "2",
          "parentId": 2,
          "isLeafNode": true,
          "childCategory": []
        },
        {
          "id": 5,
          "name": "백현",
          "boardName": "3",
          "parentId": 2,
          "isLeafNode": true,
          "childCategory": []
        },
        {
          "id": 6,
          "name": "시우민",
          "boardName": "4",
          "parentId": 2,
          "isLeafNode": true,
          "childCategory": []
        }
      ]
    },
    {
      "id": 7,
      "name": "방탄소년단",
      "parentId": 1,
      "isLeafNode": false,
      "childCategory": [
        {
          "id": 8,
          "name": "공지사항",
          "boardName": "5",
          "parentId": 7,
          "isLeafNode": true,
          "childCategory": []
        },
        {
          "id": 9,
          "name": "익명게시판",
          "boardName": "6",
          "parentId": 7,
          "isLeafNode": true,
          "childCategory": []
        },
        {
          "id": 10,
          "name": "뷔",
          "boardName": "7",
          "parentId": 7,
          "isLeafNode": true,
          "childCategory": []
        }
      ]
    }
  ]
}
```

## 테스트 방법
1. Test 실행하기
2. 테스트 웹 접속
- 이름검색
  - https://port-0-treereplay-nx562olf9wyc5i.sel3.cloudtype.app/find-name/블랙핑크
- 아이디 검색
  - https://port-0-treereplay-nx562olf9wyc5i.sel3.cloudtype.app/find-id/1



