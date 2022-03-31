package com.mjuteam2.TeamOne.bookmark;

import com.mjuteam2.TeamOne.borad.Board;
import com.mjuteam2.TeamOne.member.Member;
import lombok.Getter;
import org.apache.tomcat.jni.Local;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
public class BookMark {

    @Id @GeneratedValue
    @Column(name = "bookmark_id")
    private Long id;

    @CreationTimestamp
    private LocalDate createdAt;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

}
