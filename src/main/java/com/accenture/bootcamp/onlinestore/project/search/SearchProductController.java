package com.accenture.bootcamp.onlinestore.project.search;

import com.sun.xml.bind.v2.TODO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchProductController {

    private final SearchProductService searchService;

    public SearchProductController(SearchProductService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/search-result")
    public String findProductByName(@RequestParam(value = "search") String query, Model model) {
        model.addAttribute("query", query);
        model.addAttribute("searchResults", searchService.getSearchBarResults(query));
        return "shop/search";
    }

//    TODO work on searchResults style
}
