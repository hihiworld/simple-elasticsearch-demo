package com.yaologos.searchhouse.service;

import java.util.List;

public interface SearchService {
    boolean index(String username);
    boolean remove(String username);

    List<String> query(String keyword);
}
