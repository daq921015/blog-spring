package top.smartpos.blog.utils;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.HibernateValidator;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;
import top.smartpos.blog.enums.ResultEnum;
import top.smartpos.blog.exceptions.ApiException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

/**
 * 项目工具类
 */
public class SpringUtils {
    /**
     * 获取请求上下文
     *
     * @return
     */
    public static HttpServletRequest obtainHttpServletRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    /**
     * 获取serverlet容器上下文
     *
     * @return
     */
    public static ServletContext obtainServletContext() {
        return obtainHttpServletRequest().getServletContext();
    }

    /**
     * 获取程序上下文
     *
     * @return
     */
    public static ApplicationContext obtainApplicationContext() {
        return WebApplicationContextUtils.getWebApplicationContext(obtainServletContext());
    }

    /**
     * 获取类及其父类的所有属性
     *
     * @param modelClass
     * @return
     */
    public static List<Field> obtainAllFields(Class<?> modelClass) {
        ArrayList<Field> allFields = new ArrayList<>();
        while (modelClass != Object.class) {//循环遍历类及其所有父类中声明变量
            Field[] fields = modelClass.getDeclaredFields();
            for (Field field : fields) {
                int modifiers = field.getModifiers();
                //属性修饰符不能为 static final native
                if (!(Modifier.isStatic(modifiers) || Modifier.isFinal(modifiers) || Modifier.isNative(modifiers))) {
                    allFields.add(field);
                }
            }
            modelClass = modelClass.getSuperclass();
        }
        return allFields;
    }

    /**
     * 获取请求参数
     *
     * @return
     */
    public static Map<String, String> obtainRequestParameters() {
        HttpServletRequest request = obtainHttpServletRequest();
        Map<String, String> requestParameters = new LinkedHashMap<>();
        Map<String, String[]> parameterMap = request.getParameterMap();
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            requestParameters.put(entry.getKey(), StringUtils.trimToNull(StringUtils.join(entry.getValue(), ",")));
        }
        return requestParameters;
    }

    /**
     * 根据Map内容获取对象实例
     *
     * @param modelClass
     * @param requestParameters
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> T instantiateObject(Class<T> modelClass, Map<String, String> requestParameters) throws Exception {
        T obj = modelClass.newInstance();
        BeanUtils.populate(obj, requestParameters);
        return obj;
    }

    /**
     * 获取验证器
     *
     * @return
     */
    public static Validator obtainValidator() {
        ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class).configure().buildValidatorFactory();
        return validatorFactory.getValidator();
    }

    public static <T> T validateAndThrow(Class<T> modelClass) throws Exception {
        Map<String, String> requestParameters = obtainRequestParameters();
        T obj = instantiateObject(modelClass, requestParameters);
        Validator validator = obtainValidator();
        List<Field> allFields = obtainAllFields(modelClass);
        for (Field field : allFields) {//逐个遍历所有类属性（字段），验证属性注解，不通过抛出异常
            String fieldName = field.getName();
            Iterator<ConstraintViolation<T>> iterator = validator.validateProperty(obj, fieldName).iterator();
            if (iterator.hasNext()) {
                ConstraintViolation<T> constraintViolation = iterator.next();
                String message = constraintViolation.getMessage();
                //更改枚举，参数验证异常的提示内容
                ResultEnum param_validate = ResultEnum.PARAM_VALIDATE_ERROR;
                param_validate.setMsg(message);
                throw new ApiException(param_validate);
            }
        }
        return obj;
    }
}
