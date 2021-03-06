package com.ithillel.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

@Component
public class ListStorage implements Storage {


    private Map<String, Object> map = new HashMap<>();

    @Override
    public void compute(String key, BiFunction<String, Object, Object> remappingFunction) {
        map.compute(key, remappingFunction);
    }

    @Override
    public Object get(String key) {
        return map.get(key);
    }
}
