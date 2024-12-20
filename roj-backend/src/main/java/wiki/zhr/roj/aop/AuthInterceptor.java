package wiki.zhr.roj.aop;

import wiki.zhr.roj.annotation.AuthCheck;
import wiki.zhr.roj.common.ErrorCode;
import wiki.zhr.roj.exception.BusinessException;
import wiki.zhr.roj.model.entity.User;
import wiki.zhr.roj.model.enums.UserRoleEnum;
import wiki.zhr.roj.service.UserService;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 权限校验 AOP
 *
 * @author zouhr
 * 
 */
@Aspect
@Component
public class AuthInterceptor {

    @Resource
    private UserService userService;

    /**
     * 执行拦截
     *
     * @param joinPoint
     * @param authCheck
     * @return
     */
    @Around("@annotation(authCheck)")  // 拦截注解，拦截所有带有@AuthCheck注解的方法
    public Object doInterceptor(ProceedingJoinPoint joinPoint, AuthCheck authCheck) throws Throwable {
        String mustRole = authCheck.mustRole();  // 这里以mustRole = UserConstant.ADMIN_ROLE (admin)为例
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes(); // 获取请求属性
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();  // 获取请求
        // 当前登录用户
        User loginUser = userService.getLoginUser(request);
        // 必须有该权限才通过
        if (StringUtils.isNotBlank(mustRole)) {  // 如果mustRole不为空
            UserRoleEnum mustUserRoleEnum = UserRoleEnum.getEnumByValue(mustRole);  // 通过value = admin获取枚举 ADMIN，这里是需要的权限，也就是注解中指定的权限
            if (mustUserRoleEnum == null) {  // 如果枚举为空，说明权限不合法
                throw new BusinessException(ErrorCode.NO_AUTH_ERROR);
            }
            String userRole = loginUser.getUserRole();  // 获取当前用户的权限，和需要的权限进行比较
            // 如果被封号，直接拒绝
            if (UserRoleEnum.BAN.equals(mustUserRoleEnum)) {
                throw new BusinessException(ErrorCode.NO_AUTH_ERROR);
            }
            // 必须有管理员权限
            if (UserRoleEnum.ADMIN.equals(mustUserRoleEnum)) {
                if (!mustRole.equals(userRole)) {  // 但是当前用户的权限不是管理员权限
                    throw new BusinessException(ErrorCode.NO_AUTH_ERROR);
                }
            }
        }
        // 通过权限校验，放行
        return joinPoint.proceed();
    }
}

