package com.hamletshu.restapi.entity.controller;

import com.hamletshu.restapi.entity.entity.Post; // 오류? (원인 com.hamleshu.restapi.Post 에서 post 지정하지 않음.)
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List; // 사용이 왜 안될까? (수정완 , 원인 사용을 안했어서 list를)
import java.util.Map;

@RestController
@RequestMapping(value = "/posts" , produces = MediaType.APPLICATION_JSON_VALUE)
public class PostController {
    @RequestMapping(value = "" , consumes = MediaType.APPLICATION_JSON_VALUE)
    //게시글 추가 Post 요청시 value 는 로컬호스트8080/posts를 의미
    public ResponseEntity<Void> createPost(@RequestBody Map<String, Object> requestBody){
        //Postman 요청시 메시지가 없을때 로그를 찍어봄
        System.out.println("createPost");
        //정상작동시 상태리턴 (200)
        return new ResponseEntity<>(HttpStatus.OK);
    }
        //목록 조회
        //get 요청시 value는 로컬호스트8080/posts의미
             @GetMapping(value="")
             public List<Post> getPostList(@RequestParam(value = "postId", required = false) Long postId) {
                 //임의로 10개의 데이터 생성
                 ArrayList<Post> posts = new ArrayList<>();
                 for(int i = 0; i < 5; i++) {
                     Post post = Post.builder().postId(i + 1L).title("title" + i + 1L).contents("contents" + i + 1L).build();
                     posts.add(post);
                 }
                 return posts;
             }

    //게시물 조회
    //get 요청시 value=postId 데이터 조회를 위해 설정
    //localhost:8080/posts/1
    @GetMapping(value = "/{postId}")
    public Post getPost(@PathVariable Long postId){
        //데이터베이스 연동이 안되어있어 임시로 객체를 넘겨줌
        //builder 오류?
        Post post = Post.builder().postId(postId).title("title" + postId).title("title" + postId).contents("contents" + postId).build();
        return post;
    }
    @PutMapping(value = "/{postId}") //게시글 데이터 수정
    public ResponseEntity<Void> updatePost(@PathVariable Long postId, @RequestBody Map<String,Object> requestbody) {
        System.out.println("UpdatePost"); //DB cnnt X 임시처리
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{postId}") // 삭제요청시 데이터를 설정
    public ResponseEntity<Void> deletePost(@PathVariable Long postId){
        System.out.println("DeletePost");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
