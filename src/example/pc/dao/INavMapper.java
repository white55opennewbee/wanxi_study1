package example.pc.dao;

import example.pc.Utils.ClassReflictionForDaoUtil;
import example.pc.Utils.Jdbc_Utils;
import example.pc.entity.Nav;

import java.util.List;

/**
 * @author pc
 * @date 2020/12/12
 */
public interface INavMapper {
     List<Nav> getNavs();
}
