package dao;

import org.apache.ibatis.annotations.Param;
import pojo.Teacher;

public interface TeacherMapper {

    Teacher getTeacher(@Param("teachId") int id);
}
