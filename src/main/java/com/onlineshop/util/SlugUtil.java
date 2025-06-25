package com.onlineshop.util;

import com.github.slugify.Slugify;

public class SlugUtil {
    private static final Slugify slugify = Slugify.builder().lowerCase(true).build();

    public static String toSlug (String input){
        return slugify.slugify(input);
    }
}
