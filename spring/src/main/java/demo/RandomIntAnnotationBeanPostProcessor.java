package demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Random;

@Component
public class RandomIntAnnotationBeanPostProcessor implements BeanPostProcessor {

  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
    Field[] declaredFields = bean.getClass().getDeclaredFields();

    for (var field: declaredFields) {
      var annotation = field.getAnnotation(RandomInt.class);
      if (annotation != null){
        int min = annotation.min();
        int max = annotation.max();
        int count = new Random().nextInt(max - min) + min;
        field.setAccessible(true);
        ReflectionUtils.setField(field, bean, count);
      }
    }
    return bean;
  }
}
