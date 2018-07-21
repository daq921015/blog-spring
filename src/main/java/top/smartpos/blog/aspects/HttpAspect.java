//package top.smartpos.blog.aspects;
//
//import org.apache.commons.lang.StringUtils;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//import top.smartpos.blog.annotations.ApiRestAction;
//import top.smartpos.blog.exceptions.ApiException;
//import top.smartpos.blog.utils.LogUtils;
//import top.smartpos.blog.utils.ResultUtils;
//import top.smartpos.blog.utils.SpringUtils;
//
//import javax.servlet.http.HttpServletRequest;
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
//
//@Aspect
//@Component
//@Order
//public class HttpAspect {
//    @Pointcut("execution(public * top.smartpos.blog.controllers..*.*(..))")
//    public void log() {
//
//    }
//
//    private void LogRequestInfo(ProceedingJoinPoint proceedingJoinPoint) {
//        HttpServletRequest request = SpringUtils.obtainHttpServletRequest();
//        LogUtils.info("url={}", request.getRequestURL());
////        LogUtils.info("method={}", request.getMethod());
////        LogUtils.info("ip={}", request.getRemoteAddr());
////        LogUtils.info("class_method={}", proceedingJoinPoint.getSignature().getDeclaringTypeName() + "." + proceedingJoinPoint.getSignature().getName());
////        LogUtils.info("args={}", proceedingJoinPoint.getArgs());
//    }
//
//    /**
//     * 环绕拦截具有@ApiRestAction注解的Controller
//     *
//     * @param proceedingJoinPoint //     * @param apiRestAction
//     * @return
//     * @throws Throwable
//     */
//    @Around("log() && @annotation(apiRestAction) ")
//    public Object doAround(ProceedingJoinPoint proceedingJoinPoint, ApiRestAction apiRestAction) throws Throwable {
//        LogRequestInfo(proceedingJoinPoint);
//        Class<?> modelClass = apiRestAction.modelClass();
//        Class<?> serviceClass = apiRestAction.serviceClass();
//        String methodName = apiRestAction.methodName();
//        String error = apiRestAction.error();
//        if (modelClass != Object.class && serviceClass != Object.class && StringUtils.isNotBlank(methodName)) {//判断注解内容是否正确
//            Object object = SpringUtils.validateAndThrow(modelClass);
//            try {
//                Method method = serviceClass.getMethod(methodName, modelClass);
//                Object returnValue = method.invoke(SpringUtils.obtainApplicationContext().getBean(serviceClass), object);//验证接口参数，并调用后端服务方法
////                return ResultUtils.success(returnValue);
//                return returnValue;
//            } catch (InvocationTargetException e) {
//                Throwable targetException = e.getTargetException();//转成原始异常类型
//                if (targetException instanceof ApiException && StringUtils.isNotBlank(error)) {
//                    ApiException apiException = (ApiException) targetException;//转成自己封装的异常
//                    apiException.getResultEnum().setMsg(error);
//                    throw apiException;
//                }
//                throw targetException;//不为自己封装异常或者注解中没有error，抛出原始异常
//            }
//        }
//        return proceedingJoinPoint.proceed();
//    }
//}
