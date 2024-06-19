package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.impl.BlogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private BlogServiceImpl blogService;

    @GetMapping("")
    public ModelAndView homeBlog() {
        ModelAndView modelAndView = new ModelAndView("/home");
        List<Blog> blog = blogService.findAll();
        modelAndView.addObject("blogs", blog);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView crate() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("blogs", new Blog());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(Blog blog, RedirectAttributes attributes) {
        blogService.save(blog);
        attributes.addFlashAttribute("message", "Added new blog successfully");
        return "redirect:/blogs";
    }

    @GetMapping("/update/{id}")
    public ModelAndView formUpdate(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/update");
        modelAndView.addObject("blogs", blogService.findById(id));
        return modelAndView;
    }

    @PostMapping("/update")
    public String update(Blog blog, RedirectAttributes attributes) {
        blogService.save(blog);
        attributes.addAttribute("message", "Update successful");
        return "redirect:/blogs";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes attributes) {
        Blog blog = blogService.findById(id);
        blogService.delete(blog.getId());
        attributes.addAttribute("message", "deleted successfully");
        return "redirect:/blogs";
    }
    @GetMapping("/view/{id}")
    public ModelAndView view(@PathVariable Long id) {
      ModelAndView modelAndView = new ModelAndView("/view");
      modelAndView.addObject("blog", blogService.findById(id));
      return modelAndView;
    }
}
