package com.aini.express.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.aini.express.common.annotations.Mapper;
import com.aini.express.dto.TestDTO;

@Repository
@Mapper
public interface TestMapper {
    
    /**  테스트 리스트 */
    public List<TestDTO> getData() throws Exception;
    
}
