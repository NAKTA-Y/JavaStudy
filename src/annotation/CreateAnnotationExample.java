package annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@CreateAnnotation(testedBy = "aaa", testTools = {"Test", "Test2"})
public class CreateAnnotationExample {
    public static void main(String[] args) {
        Class<CreateAnnotationExample> cls = CreateAnnotationExample.class;

        CreateAnnotation anno = cls.getAnnotation(CreateAnnotation.class);
        System.out.println(anno.count());
        System.out.println(anno.testedBy());
        System.out.println(anno.testTools());

        for (String s : anno.testTools()) {
            System.out.println(s);
        }
    }
}

@Retention(RetentionPolicy.RUNTIME)
@interface CreateAnnotation {
    int count() default 1;
    String testedBy();
    String[] testTools() default {"JUnit", "Junit5"};
}