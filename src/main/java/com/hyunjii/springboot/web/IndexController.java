package com.hyunjii.springboot.web;

import com.hyunjii.springboot.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    // read
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts",postsService.findAllDesc());

        return "index";
    }

    // insert
    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }



}
