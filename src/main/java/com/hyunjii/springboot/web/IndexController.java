package com.hyunjii.springboot.web;

import com.hyunjii.springboot.config.auth.LoginUser;
import com.hyunjii.springboot.config.auth.dto.SessionUser;
import com.hyunjii.springboot.domain.user.User;
import com.hyunjii.springboot.service.posts.PostsService;
import com.hyunjii.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    //조회, 메인 화면 이동
    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts",postsService.findAllDesc());

        if(user != null) {
            model.addAttribute("userName", user.getName());
        }

        return "index";
    }

    //insert 화면 이동
    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    //update 화면 이동
    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }


}
