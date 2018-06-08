package org.yunpeng.tryspringboot.storage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.yunpeng.tryspringboot.models.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
    @Query("from User u where u.title = :title")
    Post findPost(@Param("title") String title);

    Post findByTitle(String title);

    Post findByTitleAndBody(String title, String body);
}
