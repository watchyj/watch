package com.ds.watchtable.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"store","member"})
@Table(name = "review")
public class Review extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewNum;

    private String text;

    public void changeText(String text){
        this.text = text;
    }

    @JoinColumn(name = "memberNum")
    @ManyToOne(fetch = FetchType.LAZY)
    Member member;

    @JoinColumn(name = "storeNum")
    @ManyToOne(fetch = FetchType.LAZY)
    Store store;

}
