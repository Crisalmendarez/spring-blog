package controller;

import com.example.springblog.models.Post;
import com.example.springblog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    private PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String postsIndex(Model model) {
        // Instantiate the list to hold all the Post objects
        List<Post> allPosts = postDao.findAll();
        model.addAttribute("allPosts", allPosts);
        // return the template
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String singlePost(@PathVariable long id, Model model) {
        Post singlePost = new Post(id, "First Post!", "This is the first time I've ever used Spring!");
        model.addAttribute("post", singlePost);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String showCreateForm() {
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String submitPost(@RequestParam(name = "title")String title, @RequestParam(name = "description")String description) {
        Post post = new Post();
        post.setTitle(title);
        post.setBody(description);
        postDao.save(post);
        return "redirect:/posts";
    }

}
