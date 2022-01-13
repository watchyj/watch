package com.ds.watchtable.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "likes")
public class Likes extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long likesNum;

    private String likes;

    @JoinColumn(name = "memberNum")
    @ManyToOne(fetch = FetchType.LAZY)
    Member member;

    @JoinColumn(name = "storeNum")
    @ManyToOne(fetch = FetchType.LAZY)
    Store store;

}
