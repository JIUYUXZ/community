package com.nowcoder.community;

import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.service.DiscussPostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class CaffeineTests {

    @Autowired
    private DiscussPostService postService;

    @Test
    public void initDataForTest() {
        for (int i = 0; i < 30; i++) {
            DiscussPost post = new DiscussPost();
            post.setUserId(111);
            post.setTitle("AI带来的机遇该如何抓住");
            post.setContent("随着chatGPT的爆火，越来越多人在生活或是工作上依赖于AI。前不久看到一个利用AI赚钱的视频，" +
                    "大致内容是在抖音等短视频APP找到带货视频，利用chatGPT重写文案，在发布于TikTok，同时带上卖货链接，有人下单就用1688一件代发" +
                    "一番操作下来收入可观，看得我有些心动，在考虑以后是否也发展一份类似的副业。");
            post.setCreateTime(new Date());
            post.setScore(Math.random() * 2000);
            postService.addDiscussPost(post);
        }
    }

    @Test
    public void testCache() {
        System.out.println(postService.findDiscussPosts(0, 0, 10, 1));
        System.out.println(postService.findDiscussPosts(0, 0, 10, 1));
        System.out.println(postService.findDiscussPosts(0, 0, 10, 1));
        System.out.println(postService.findDiscussPosts(0, 0, 10, 0));
    }

}
