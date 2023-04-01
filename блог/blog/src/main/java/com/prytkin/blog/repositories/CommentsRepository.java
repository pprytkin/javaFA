package com.prytkin.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.prytkin.blog.models.Comments;

import java.util.List;

public interface CommentsRepository extends JpaRepository<Comments, Long> {
    List<Comments> findByParentId(Long parentId);
}
