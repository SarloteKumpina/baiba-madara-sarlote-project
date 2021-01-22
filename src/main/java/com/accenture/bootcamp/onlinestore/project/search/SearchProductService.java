package com.accenture.bootcamp.onlinestore.project.search;

import com.accenture.bootcamp.onlinestore.project.products.Product;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class SearchProductService implements SearchProductMapper {

    private final SearchProductMapper searchProductMapper;
    private final String[] stopWords = new String[]{"a", "an", "and", "as", "at", "be", "by", "if", "in", "is",
            "no", "of", "on", "or", "the", "to"};

    public SearchProductService(SearchProductMapper searchProductMapper) {
        this.searchProductMapper = searchProductMapper;
    }

    List<Product> getSearchBarResults(String query) {
        return checkQueryIfNotValid(query) ? Collections.emptyList()
                : searchProductMapper.findByNameContains(query.trim());
    }

    Boolean checkQueryIfNotValid(String query) {
        return query.trim().isEmpty() || checkForStopWords(query.trim()).equals("");
    }

    String checkForStopWords(String trimmedQuery) {
        for (String word : stopWords) {
            if (trimmedQuery.equals(word)) {
                return "";
            }
        }
        return trimmedQuery;
    }

    public List<Product> findByNameContains(String name) {
        List<Product> products = searchProductMapper.findByNameContains(name);
        for (Product product : products) {
            if (product.getName().contains(name)) {
                products.add(product);
            }
        }
        return products;
    }
}
