package com.prytkin.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.prytkin.blog.models.Posts;

public interface PostsRepository extends JpaRepository<Posts, Long> {
}
