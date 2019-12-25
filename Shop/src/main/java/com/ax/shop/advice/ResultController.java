//package com.ax.shop.controller;
//
//import com.ax.shop.annotation.ResponseResultBody;
//import com.ax.shop.entity.Result;
//import com.ax.shop.util.axtools.AxResultEntity;
//import org.springframework.core.MethodParameter;
//import org.springframework.core.annotation.AnnotatedElementUtils;
//import org.springframework.core.annotation.AnnotationUtils;
//import org.springframework.http.MediaType;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.http.server.ServerHttpRequest;
//import org.springframework.http.server.ServerHttpResponse;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
//
//import javax.annotation.Resource;
//import java.lang.annotation.Annotation;
//import java.lang.reflect.AnnotatedElement;
//
////@RestControllerAdvice
//public class ResultController implements ResponseBodyAdvice<Object> {
//
////    private static final Class<? extends Annotation> ANNOTATION_TYPE = ResponseResultBody.class;
//
//    private static final Class<? extends Annotation> ANNOTATION_TYPE = ResponseBody.class;
//
//    /**
//     * 判断类或者方法是否使用了 @ResponseResultBody
//     */
//    @Override
//    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> converterType) {
////        return AnnotatedElementUtils.hasAnnotation(methodParameter.getContainingClass(), ANNOTATION_TYPE) || methodParameter.hasMethodAnnotation(ANNOTATION_TYPE);
//
////        AnnotatedElement annotatedElement = methodParameter.getAnnotatedElement();
////        ResponseBody focusController = AnnotationUtils.findAnnotation(annotatedElement, ResponseBody.class);
////        System.out.println("focusController = " + focusController);
////        return focusController != null;
//
//        return true;
//    }
//    /**
//     * 当类或者方法使用了 @ResponseResultBody 就会调用这个方法
//     */
//    @Override
//    public Object beforeBodyWrite(Object object, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
//
//        System.out.println("beforeBodyWrite object = " + object);
//        System.out.println("returnType = " + returnType);
//        System.out.println("selectedContentType = " + selectedContentType);
//
//        System.out.println("instanceof = " + (object instanceof Resource));
//        System.out.println("selectedContentType == MediaType.TEXT_HTML = " + (selectedContentType == MediaType.TEXT_HTML));
//
//        if (object instanceof Resource) {
//
//            return object;
//        }
//
//        if (selectedContentType == MediaType.TEXT_HTML){
//            return object;
//        }
//
//        //         防止重复包裹的问题出现
//        if (object instanceof AxResultEntity) {
//            return object;
//        }
//
//        // 这里 会拦截html
//        return AxResultEntity.Success(object);
//
//
//
////        return object;
//    }
//}
