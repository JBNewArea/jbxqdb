package com.numberONe.shiro;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cas.CasRealm;
import org.apache.shiro.cas.CasToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.jasig.cas.client.validation.Assertion;
import org.jasig.cas.client.validation.TicketValidationException;
import org.jasig.cas.client.validation.TicketValidator;
import org.springframework.beans.factory.annotation.Autowired;

import com.numberONe.entity.ResFormMap;
import com.numberONe.entity.UserFormMap;
import com.numberONe.mapper.ResourcesMapper;
import com.numberONe.mapper.UserMapper;

public class MyCasRealm extends CasRealm{
	private Logger LOGGER = Logger.getLogger(MyCasRealm.class);
	    
	    @Inject
		private ResourcesMapper resourcesMapper;

		@Inject
		private UserMapper userMapper;

		/**
		 * 授权
		 * 只有需要验证权限时才会调用, 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.在配有缓存的情况下，只加载一次.
		 */
		@Override
		protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
			String loginName = SecurityUtils.getSubject().getPrincipal().toString();
			if (loginName != null) {
				String userId = SecurityUtils.getSubject().getSession().getAttribute("userSessionId").toString();
				List<ResFormMap> rs = resourcesMapper.findUserResourcess(userId);
				// 权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
				SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
				// 用户的角色集合
				// info.addRole("default");
				// 用户的角色集合
				// info.setRoles(user.getRolesName());
				// 用户的角色对应的所有权限，如果只使用角色定义访问权限
				for (ResFormMap resources : rs) {
					info.addStringPermission(resources.get("resKey").toString());
				}

				return info;
			}
			return null;
		}

		/**
		 * 
		 * 
		 * 登陆认证
		 * 
		 * 
		 * 认证回调函数,登录时调用
		 * 首先根据传入的用户名获取User信息；然后如果user为空，那么抛出没找到帐号异常UnknownAccountException；
		 * 如果user找到但锁定了抛出锁定异常LockedAccountException；最后生成AuthenticationInfo信息，
		 * 交给间接父类AuthenticatingRealm使用CredentialsMatcher进行判断密码是否匹配，
		 * 如果不匹配将抛出密码错误异常IncorrectCredentialsException；
		 * 另外如果密码重试此处太多将抛出超出重试次数异常ExcessiveAttemptsException；
		 * 在组装SimpleAuthenticationInfo信息时， 需要传入：身份信息（用户名）、凭据（密文密码）、盐（username+salt），
		 * CredentialsMatcher使用盐加密传入的明文密码和此处的密文密码进行匹配。
		 */
	    @Override
	    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

	        CasToken casToken = (CasToken) token;
	        if (token == null) {
	            return null;
	        }

	        String ticket = (String) casToken.getCredentials();
	        if (StringUtils.isBlank(ticket)) {
	            return null;
	        }

	        TicketValidator ticketValidator = ensureTicketValidator();

	        Assertion casAssertion;
	        String username = null;
	        try {
	            casAssertion = ticketValidator.validate(ticket, getCasService());

	            AttributePrincipal casPrincipal = casAssertion.getPrincipal();
	            username = casPrincipal.getName();

	            Map<String, Object> attributes = casPrincipal.getAttributes();

	            System.out.println("attributes:"+attributes);

	            casToken.setUserId(username);
	            String rememberMeAttributeName = getRememberMeAttributeName();
	            String rememberMeStringValue = (String) attributes.get(rememberMeAttributeName);
	            boolean isRemembered = rememberMeStringValue != null && Boolean.parseBoolean(rememberMeStringValue);
	            if (isRemembered) {
	                casToken.setRememberMe(true);
	            }
	            UserFormMap user = new UserFormMap();
				user.put("accountName", "" + username + "");
				SimpleAuthenticationInfo authenticationInfo = null;
				List<UserFormMap> userFormMaps = null;
		        // 根据用户名加载记录
		        try {
		        	userFormMaps = userMapper.findByNames(user);
		        	/*authenticationInfo = new SimpleAuthenticationInfo(username, // 用户名
			        		userFormMaps.get(0).get("password"), // 密码
							ByteSource.Util.bytes(username + "" + userFormMaps.get(0).get("credentialsSalt")),// salt=username+salt
							getName() // realm name
					);*/
		        	if ("2".equals(userFormMaps.get(0).get("locked"))) {
						throw new LockedAccountException(); // 帐号锁定
					}
		        } catch (Exception e) {
		            e.printStackTrace();
		            throw new AuthenticationException("根据登录用户名" + username + "获取用户数据失败.", e);
		        }
		        if(userFormMaps!=null){
		        	//当登录成功，将用户信息存入session，由于正常登录用户信息是从session中取，
		        												//所以这样controller里获取用户信息的方法都不用改动
		        	Session session = SecurityUtils.getSubject().getSession();
		 			session.setAttribute("userSession", userFormMaps.get(0));
		 			session.setAttribute("userSessionId", userFormMaps.get(0).get("id"));
		        }
	            List<Object> principals = org.apache.shiro.util.CollectionUtils.asList(username, attributes);
	            PrincipalCollection principalCollection = new SimplePrincipalCollection(principals, getName());

	            return new SimpleAuthenticationInfo(principalCollection, ticket);
	        } catch (TicketValidationException e1) {
	            e1.printStackTrace();
	        }
	        
	        
	        /**======================================目前针对账户锁定、禁用等特殊需求，暂未实现，因为CAS处理这些情况比较麻烦，后期会完善。============================================*/
	        
	        
	        if (StringUtils.isEmpty(username)) {
	            LOGGER.error("登录用户名为空.");
	            throw new AccountException("登录用户名为空.");
	        }
	        return null;

			

	        /*if (user == null) {
	            final String errmsg = "未查询到对应的用户数据，登录用户名:[" + username + "]";
	            LOGGER.error(errmsg);
	            throw new UnknownAccountException(errmsg);
	        } else if (user.getStatus() == UserStatus.LOCK) {// 锁定状态
	            throw new LockedAccountException("帐户 [" + username + "] 被锁定.");
	        } else if (user.getStatus() == UserStatus.DISABLE) {
	            throw new DisabledAccountException("帐户 [" + username + "] 被禁用");
	        }*/
	     // 当验证都通过后，把用户信息放在session里
	        
	       
	    }


	    /**
	     * 更新用户授权信息缓存.
	     */
		public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
			super.clearCachedAuthorizationInfo(principals);
		}
		/**
	     * 更新用户信息缓存.
	     */
		public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
			super.clearCachedAuthenticationInfo(principals);
		}

		/**
		 * 清除用户授权信息缓存.
		 */
		public void clearAllCachedAuthorizationInfo() {
			getAuthorizationCache().clear();
		}

		/**
		 * 清除用户信息缓存.
		 */
		public void clearAllCachedAuthenticationInfo() {
			getAuthenticationCache().clear();
		}
		
		/**
		 * 清空所有缓存
		 */
		public void clearCache(PrincipalCollection principals) {
			super.clearCache(principals);
		}


		/**
		 * 清空所有认证缓存
		 */
		public void clearAllCache() {
			clearAllCachedAuthenticationInfo();
			clearAllCachedAuthorizationInfo();
		}
}
