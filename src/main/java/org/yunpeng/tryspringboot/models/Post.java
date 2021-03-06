package org.yunpeng.tryspringboot.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 5)
    private String title;

    @Column
    private String body;

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }
}
