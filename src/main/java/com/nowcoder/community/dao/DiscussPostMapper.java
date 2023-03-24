package com.nowcoder.community.dao;

import com.nowcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DiscussPostMapper {

    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit, int orderMode); // orderMode默认0按时间排，1则按热度排

    // @Param注解用于给参数取别名,
    // 如果只有一个参数,并且在<if>里使用,则必须加别名.
    int selectDiscussPostRows(@Param("userId") int userId);

    /*
    * 声明插入帖子的功能
    * */
    int insertDiscussPost(DiscussPost discussPost);

    /*
    * 根据帖子id查询帖子的详细内容
    * */
    DiscussPost selectDiscussPostById(int id);

    /*
    * 根据帖子id更新评论数量
    * */
    int updateCommentCount(int id, int commentCount);

    // 修改帖子类型
    int updateType(int id, int type);

    // 修改帖子状态
    int updateStatus(int id, int status);

    // 更新帖子分数
    int updateScore(int id, double score);

}
