package cn.llf.test;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import cn.llf.pojo.Student;
public class Main {
	public static void main(String[] args) throws IOException {
		InputStream in=Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sqlSession=new SqlSessionFactoryBuilder().build(in);
		SqlSession sql=sqlSession.openSession();
		try {
				List<Student> list=sql.selectList("cn.llf.mapper.StudentMapper.getall");
				for(Student s : list){
					System.out.println(s.getName());
					}
				int count=sql.selectOne("cn.llf.mapper.StudentMapper.count");
				System.out.println(count);
		} finally{
			sql.close();
		}
	}
}