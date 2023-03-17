package com.hamletshu.restapi.entity.entity;

import com.fasterxml.jackson.annotation.JsonTypeId;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.*; // 왜??
@Entity
@Getter //클래스 내 모든 필드에 getter 메서드 생성
@Builder
@NoArgsConstructor // 기본 생성자 자동 추가 public Post(){}과 동일
@AllArgsConstructor // 해당 클래스의 빌더 패턴 클래스 생성 (생성자 상단에 선언시 포함된 필드만 빌더에 포함)
public class Post {
    @Id // 해당 테이블의 PK필드를 나타냄 : 이라는데 뭔소린지 하나도 모루겠다
    @GeneratedValue(strategy = GenerationType.IDENTITY) //pk 생성규칙(1++)
    private Long postId;
    @Column(length = 500, nullable = false)
    private String title;
    //type -> text 공백불가
    @Column(columnDefinition = "TEXT" , nullable = false)
    private String contents;

}