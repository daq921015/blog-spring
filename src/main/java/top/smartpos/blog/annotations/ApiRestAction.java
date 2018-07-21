package top.smartpos.blog.annotations;


import java.lang.annotation.*;

/**
 * 注解：添加到Controller Method上，验证完毕直接请求service
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ApiRestAction {
    /**
     * 参数验证model class
     *
     * @return
     */
    Class<?> modelClass() default Object.class;

    /**
     * 服务层 class
     *
     * @return
     */
    Class<?> serviceClass() default Object.class;

    /**
     * 服务层 处理方法名称
     *
     * @return
     */
    String methodName() default "";

    /**
     * controller方法注解中加入此属性，后端返回的异常全部更改此信息
     *
     * @return
     */
    String error() default "";
}
