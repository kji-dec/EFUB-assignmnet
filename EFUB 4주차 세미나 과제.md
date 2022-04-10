# EFUB 4주차 세미나 과제

###### Back Lead 김지인



### 01. 학사 정보 관리 ERD

[링크] https://drive.google.com/file/d/1x0zO18ELbvBSR8Ar7xsSqg1ih-2BRXJe/view?usp=sharing

[사진]

![image](https://user-images.githubusercontent.com/71377968/162624952-560e8348-02fe-4688-a548-a6de7a1d7dae.png)



### 02. MySQL 실습 코드

##### SWS 테이블 생성 코드

```sql
#SWS 테이블 생성 코드

#테이블 생성
CREATE TABLE sws (
    sws_id BIGINT NOT NULL AUTO_INCREMENT,
    team_name VARCHAR(25),
    PRIMARY KEY (sws_id)
);

#데이터 삽입
INSERT INTO sws(team_name) VALUES
	("베이커리"),
    ("라꾸라꾸"),
    ("STEADY"),
    ("이상청");
```



##### JOIN 코드

```sql
#JOIN 코드
SELECT member.team_number, sws.team_name,  member.name, member.position, member.email
	FROM member JOIN sws
    ON member.team_number = sws.sws_id;
```



##### JOIN 출력 결과

[JOIN 출력 결과]

![image](https://user-images.githubusercontent.com/71377968/162626189-dec0d1ee-e567-4caf-9e68-1070cba7ec0c.png)