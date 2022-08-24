package com.nowcoder.community.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary /*调配bean时，优先级更高*/

public class AlphaMybatisImplement implements AlphaDao {
    @Override
    public String select() {
        return "Mybatis";
    }
}
