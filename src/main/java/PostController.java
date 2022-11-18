package com.example.springblog;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String postsIndex() {
        return "Viewing all posts.";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String singlePost(@PathVariable long id) {
        return "Viewing individual post with the id of " + id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String showCreateForm() {
        return "Viewing the form to create a post.";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String submitPost() {
        return "New Post created!";
    }

}
