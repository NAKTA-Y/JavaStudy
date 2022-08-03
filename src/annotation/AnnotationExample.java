package annotation;

// @Override = 컴파일 시에 오버라이딩을 올바르게 했는지 체크해줌
// @Deprecated = 앞으로 사용하지 않을 것을 권장하는 필드나 메서드에 표시
// @FunctionalInterface = 함수형 인터페이스를 올바르게 작성했는지 체크해줌
// @SuppressWarnings = 컴파일러의 경고 메시지를 억제한다

import java.util.ArrayList;

class Parent {
    void parentMethod(){};
}

class Child extends Parent {
    @Override
    @Deprecated
    void parentMethod() {
        super.parentMethod();
    }
}

@FunctionalInterface
interface TestInterface {
    void test();
}

public class AnnotationExample {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        Child child = new Child();
        child.parentMethod();
    }
}
