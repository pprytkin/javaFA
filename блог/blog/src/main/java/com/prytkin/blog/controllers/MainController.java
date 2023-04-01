package com.prytkin.blog.controllers;

import com.prytkin.blog.models.Comments;
import com.prytkin.blog.models.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.prytkin.blog.repositories.PostsRepository;
import com.prytkin.blog.repositories.CommentsRepository;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    private PostsRepository postsRepository;

    @Autowired
    private CommentsRepository commentsRepository;

    @GetMapping("/")
    public String homepage(Model model) {
        Iterable<Posts> posts = postsRepository.findAll();
        model.addAttribute("posts", posts);
        return "homepage";
    }
    @GetMapping("/post/create")
    public String postCreateGet(Model model) {
        return "create_post";
    }
    @PostMapping("/post/create")
    public String postCreatePost(@RequestParam String title, @RequestParam String description, @RequestParam String text, Model model) {
        Posts post = new Posts(title, description, text);
        postsRepository.save(post);
        return "redirect:/";
    }
    @GetMapping("/post/{id}")
    public String postDetail(@PathVariable(value = "id") long id, Model model) {
        Optional<Posts> result = postsRepository.findById(id);
        ArrayList<Posts> post = new ArrayList<>();
        result.ifPresent(post::add);

        Iterable<Comments> comments = commentsRepository.findByParentId(id);

        model.addAttribute("post", post);
        model.addAttribute("comments", comments);
        return "detail_post";
    }
    @PostMapping("/post/{id}/delete")
    public String postDeletePost(@PathVariable(value = "id") long id, Model model) {
        Posts post = postsRepository.findById(id).orElseThrow();
        postsRepository.delete(post);
        return "redirect:/";
    }
    @PostMapping("/post/{id}/create-comment")
    public String postCreatePost(@PathVariable(value = "id") long id, @RequestParam String name, @RequestParam String text, Model model) {
        Comments comment = new Comments(name, text, id);
        commentsRepository.save(comment);
        return "redirect:/post/" + id;
    }
}
