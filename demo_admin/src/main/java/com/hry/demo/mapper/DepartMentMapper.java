package com.hry.demo.mapper;

import com.hry.demo.pojo.Department;
import org.apache.ibatis.annotations.*;
//全局替换  @MapperScan(value = "com.hry.demo.mapper")
//@Mapper
public interface DepartMentMapper {

    @Select("select * from department where id = #{id}")
    public Department getDeptById(Integer id);

    @Delete("delete from department where id=#{id}")
    public int deleteDeptById(Integer id);

    /**
     * 回带 id
     * */
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into department(department_name) values(#{departmentName})")
    public int insertDept(Department department);

    @Update("update department set department_name=#{departmentName} where id=#{id}")
    public int updateDept(Department department);
}
