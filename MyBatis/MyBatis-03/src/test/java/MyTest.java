import dao.StudentMapper;
import dao.TeacherMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.Student;
import pojo.Teacher;
import utils.MybatisUtils;

import java.util.List;

public class MyTest {

    @Test
    public void test1(){
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            // 获取学生列表, 并将学生对象中的teacher映射为对象
            List<Student> studentList = mapper.getStudentList();
            for (Student student : studentList) {
                System.out.println(student);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Test
    public void test2(){
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
            // 根据老师ID查找该老师的所有学生
            Teacher teacher = mapper.getTeacher(1);
            System.out.println(teacher);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
