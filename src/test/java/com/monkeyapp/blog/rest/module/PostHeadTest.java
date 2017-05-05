package com.monkeyapp.blog.rest.module;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class PostHeadTest {
    @Test
    public void testCreatePostInstanceWithValidFileName() {
        final String validFilename = "2017-0418-1053-tag-arbitrary-post-title.md";

        PostHead post = PostHead.from(validFilename);
        assertNotNull("failed to recreate post from valid file name " + validFilename, post);

        assertEquals("wrong post tag", "tag", post.getTag());
        assertEquals("wrong post name", "arbitrary-post-title", post.getTitle());
        assertEquals("wrong post id", 201704181053L, post.getId());

        assertEquals("wrong post file name", validFilename, post.toFileName());
    }

    @Test
    public void testCreatePostInstanceWithInvalidFileName() {
        final String invalidFileName = "201704181053-tag-arbitrary-post-title.md";
        PostHead post = PostHead.from(invalidFileName);
        assertNull("should not create post instance from invalid file name " + invalidFileName, post);
    }
}
