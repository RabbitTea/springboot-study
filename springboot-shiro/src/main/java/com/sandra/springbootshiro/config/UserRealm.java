package com.sandra.springbootshiro.config;

import com.sandra.springbootshiro.pojo.User;
import com.sandra.springbootshiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义的realm
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    /**
     * 授权
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        System.out.println("执行了=>授权doGetAuthorizationInfo");

        // 授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermission("user:add");

        // 拿到当前登录的这个对象
        Subject subject = SecurityUtils.getSubject();
        // 拿到User对象
        User currentUser = (User)subject.getPrincipal();

        // 从数据库中读出，设置当前用户的权限
        info.addStringPermission(currentUser.getPerms());

        return info;
    }

    /**
     * 认证
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        System.out.println("执行了=>认证doGetAuthorizationInfo");

        // 用户名和密码，在数据库中取
        String name = "root";
        String password = "123456";

        UsernamePasswordToken userToken = (UsernamePasswordToken)token;


        // 连接真实的数据库
        User user = userService.queryUserByName(userToken.getUsername());

        //if (!userToken.getUsername().equals(name)) {
        //
        //    // 会自动抛出异常
        //    return null;
        //}
        //
        //// 密码认证由shiro来完成
        //return new SimpleAuthenticationInfo("", password, "");

        if (user == null) {
            return null;
        }

        Subject current = SecurityUtils.getSubject();
        Session session = current.getSession();
        session.setAttribute("loginUser", user);

        return new SimpleAuthenticationInfo(user, user.getPwd(), "");
    }
}
