package com.qakj.crm.mapper;

import com.qakj.crm.pojo.Newdate;
import com.qakj.crm.pojo.NewdateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NewdateMapper {
    int countByExample(NewdateExample example);

    int deleteByExample(NewdateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Newdate record);

    int insertSelective(Newdate record);

    List<Newdate> selectByExample(NewdateExample example);

    Newdate selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Newdate record, @Param("example") NewdateExample example);

    int updateByExample(@Param("record") Newdate record, @Param("example") NewdateExample example);

    int updateByPrimaryKeySelective(Newdate record);

    int updateByPrimaryKey(Newdate record);
}