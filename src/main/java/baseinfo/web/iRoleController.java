package baseinfo.web;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import baseinfo.dao.iRoleDAO;
import baseinfo.dto.iRoleDTO;

public class iRoleController {
	
	public static void main(String[] args) {
		testRoleMapper();
	}
	
	private static void testRoleMapper() {
		Logger log = Logger.getLogger(iRoleController.class);
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionFactoryUtils.openSqlSession();
			iRoleDAO roleMapper = sqlSession.getMapper(iRoleDAO.class);
			iRoleDTO role = roleMapper.getRole(1L);
			log.info(role.getRoleName());
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
}
