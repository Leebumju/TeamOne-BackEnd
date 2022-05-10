package com.mjuteam2.TeamOne.borad.repository;

import com.mjuteam2.TeamOne.borad.domain.Board;
import com.mjuteam2.TeamOne.borad.domain.BoardType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

    @Query("SELECT b FROM Board b WHERE b.boardType = :boardType")
    List<Board> findAllByType(BoardType boardType);

    // 제목으로 검색
    @Query("SELECT b FROM Board b WHERE b.title LIKE %:title%")
    List<Board> searchByTitle(@Param("title") String title);

    // 내용으로 검색
    @Query("SELECT b FROM Board b WHERE b.content LIKE %:content%")
    List<Board> searchByContent(@Param("content") String content);

    // 내용+제목으로 검색
    @Query("SELECT b FROM Board b WHERE b.title LIKE %:keyword% OR b.content LIKE %:keyword%")
    List<Board> searchByTitleAndContent(@Param("keyword") String keyword);

    // 수업이름으로 검색
    @Query("SELECT b FROM Board b WHERE b.classTitle LIKE %:classTitle%")
    List<Board> searchByClassTitle(@Param("classTitle") String classTitle);
}
