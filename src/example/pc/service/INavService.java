package example.pc.service;

import example.pc.entity.Nav;

import java.util.List;

public interface INavService {
    List<Nav> getNavs();
    Nav getSingleNav(String key);
}
